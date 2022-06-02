package com.spring.data.mongodb.repository;

import java.util.List;

import com.spring.data.mongodb.model.Movimiento;
import com.spring.data.mongodb.model.Movimiento.Tipo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovimientoRepository extends MongoRepository<Movimiento, String>{
    List<Movimiento> findByTipo(Tipo tipo);
}
