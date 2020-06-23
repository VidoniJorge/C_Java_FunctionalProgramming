package com.jlv.java.functional.funcion;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;



public class OperatorAplicacion {
    public static void main(String[] args) {
        OperatorAplicacion op = new OperatorAplicacion();
        op.ejemploUnaryOperator();
        op.ejemploBinaryOperator();
    }

    private void ejemploUnaryOperator(){
        UnaryOperator<String> fotmatearTexto = new UnaryOperator<String>(){
            @Override
            public String apply(String texto) {
                return "\"" + texto + "\"";
            }
        };
        System.out.println(fotmatearTexto.apply("Pepe Argento"));
    }

    private void ejemploBinaryOperator(){
        BinaryOperator<Integer> multiplicador = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer s, Integer s2) {
                return s * s2;
            }
        };
        System.out.println(multiplicador.apply(8,9));
    }
}
