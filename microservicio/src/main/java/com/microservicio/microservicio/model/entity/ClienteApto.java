package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ClienteApto")
@Data
@NoArgsConstructor
public class ClienteApto {
    @Id
    private String idClienteApto;
    private Cliente cliente;
    private Double montoDIsponible;
    private String fechaRetiro;
    private String nroCuenta;
}
