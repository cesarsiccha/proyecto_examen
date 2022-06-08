package com.microservicio.microservicio.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolicitudRetiroTest {
    @Test
    void TestNombreSolicitudRetiro(){
        SolicitudRetiro solicitudRetiro=new SolicitudRetiro();

        Assertions.assertEquals("77221133","77221133");
    }

}