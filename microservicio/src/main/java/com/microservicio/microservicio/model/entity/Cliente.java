package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Cliente")
@Data
@NoArgsConstructor
public class Cliente {
    @Id
    private String idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private int dniCliente;
    private String telefonoCliente;
    private String correoCliente;

    private AsociacionAFP asociacionAFP;
}
