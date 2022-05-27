package com.spring.data.mongodb.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movimientos")
public class Movimiento {

    public enum Tipo {
        INGRESO,
        EGRESO
    }

    @Id
    private String id;
    private LocalDate fecha;
    private String descripcion;
    private Double cantidad;
    private Tipo tipo;

    public Movimiento() {
    }

    public Movimiento(String id, LocalDate fecha, String descripcion, Double cantidad, Tipo tipo) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Movimiento [cantidad=" + cantidad + ", descripcion=" + descripcion + ", fecha=" + fecha + ", id=" + id
                + ", tipo=" + tipo + "]";
    }
}
