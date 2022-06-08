package com.microservicio.microservicio.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ClienteTest {
    @Test
    void TestNombreCliente(){
        Cliente cliente=new Cliente();

        Assertions.assertEquals("fred","fred");
    }
}