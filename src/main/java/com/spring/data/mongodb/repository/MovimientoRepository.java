package com.spring.data.mongodb.repository;

import com.spring.data.mongodb.model.Movimiento;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovimientoRepository extends MongoRepository<Movimiento, String>{
}
