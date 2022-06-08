package com.microservicio.microservicio.service;

public class CalculaTipoCambio {

    CalculeTipoCambioExterno calculeTipoCambioExterno;

    public int nuestroTipoCambio(int precioA,int precioB){
        return calculeTipoCambioExterno.calcularTipoCambio(precioA,precioB);
    }
}
