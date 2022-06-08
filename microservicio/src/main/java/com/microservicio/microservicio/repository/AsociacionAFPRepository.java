package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.AsociacionAFP;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsociacionAFPRepository extends MongoRepository<AsociacionAFP,String> {
}
