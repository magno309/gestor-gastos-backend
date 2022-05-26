package com.spring.data.mongodb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.spring.data.mongodb.model.Movimiento;
import com.spring.data.mongodb.repository.MovimientoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class MovimientoController {

    @Autowired
    MovimientoRepository movimientoRepository;

    @GetMapping("/movimientos")
    public ResponseEntity<List<Movimiento>> getAllMovimientos() {
        try {
            List<Movimiento> movimientos = new ArrayList<>();
            movimientoRepository.findAll().forEach(movimientos::add);
            if (movimientos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movimientos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/movimientos/{id}")
    public ResponseEntity<Movimiento> getMovimientobyId(@PathVariable("id") String id) {
        Optional<Movimiento> movimientoData = movimientoRepository.findById(id);
        if (movimientoData.isPresent()) {
            return new ResponseEntity<>(movimientoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/movimientos")
    public ResponseEntity<Movimiento> createMovimiento(@RequestBody Movimiento movimiento) {
        try {
            Movimiento _movimiento = movimientoRepository.save(movimiento);
            return new ResponseEntity<>(_movimiento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/movimientos/{id}")
    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable("id") String id,
            @RequestBody Movimiento movimiento) {
        Optional<Movimiento> movimientoData = movimientoRepository.findById(id);
        if (movimientoData.isPresent()) {
            Movimiento _movimiento = movimientoData.get();
            _movimiento.setCantidad(movimiento.getCantidad());
            _movimiento.setDescripcion(movimiento.getDescripcion());
            _movimiento.setFecha(movimiento.getFecha());
            _movimiento.setTipo(movimiento.getTipo());
            return new ResponseEntity<>(movimientoRepository.save(_movimiento), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/movimientos/{id}")
    public ResponseEntity<HttpStatus> deleteMovimiento(@PathVariable("id") String id) {
        try {
            movimientoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/movimientos")
    public ResponseEntity<HttpStatus> deleteAllMovimientos() {
        try {
            movimientoRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
