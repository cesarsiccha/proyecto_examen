package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente,String> {
}
