package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("AsociacionAFP")
@Data
@NoArgsConstructor
public class AsociacionAFP {

    @Id
    private String idAsociacionAFP;
    private String nombreAFP;
}
