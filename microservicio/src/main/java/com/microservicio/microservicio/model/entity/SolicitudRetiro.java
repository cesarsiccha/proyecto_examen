package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("SolicitudRetiro")
@Data
@NoArgsConstructor
public class SolicitudRetiro {

    @Id
    private String IdSolicitudRetiro;
    private Cliente cliente;
    private Double montoRetiro;
    private ClienteApto clienteApto;

}
