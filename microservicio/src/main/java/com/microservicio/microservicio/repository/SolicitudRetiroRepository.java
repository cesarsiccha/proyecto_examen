package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.SolicitudRetiro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SolicitudRetiroRepository extends MongoRepository<SolicitudRetiro,String> {
}
