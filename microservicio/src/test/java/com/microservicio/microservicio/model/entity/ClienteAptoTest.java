package com.microservicio.microservicio.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteAptoTest {
    @Test
    void TestNombreClienteApto(){
        ClienteApto clienteApto=new ClienteApto();

        Assertions.assertEquals("fred","fred");
    }

}