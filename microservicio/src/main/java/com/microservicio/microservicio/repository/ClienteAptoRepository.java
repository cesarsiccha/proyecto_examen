package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.ClienteApto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteAptoRepository extends MongoRepository<ClienteApto,String> {
}
