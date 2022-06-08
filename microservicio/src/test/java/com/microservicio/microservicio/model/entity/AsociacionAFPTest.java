package com.microservicio.microservicio.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsociacionAFPTest {

    @Test
    void TestNombreAFP(){
        AsociacionAFP asociacionAFP=new AsociacionAFP();

        Assertions.assertEquals("prima","prima");
    }

}