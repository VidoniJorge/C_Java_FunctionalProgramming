package com.jlv.java.functional.funcion;

import java.util.function.Function;

public class Funcion {

    public static void main(String[] args) {
        Funcion func = new Funcion();
        func.funcionPura();
    }

    //Ejemplos de funciones puras
    public void funcionPura() {
        System.out.println("Inicio Ejemplos de funciones puras");
        Function<Integer,Integer> calcularCuadrado = new Function<Integer,Integer>(){
            @Override
            public Integer apply(Integer o) {
                return o * o;
            }
        };
        System.out.println("\tEl resultado de aplicar la función calcularCuadrado a 8 es:  " + calcularCuadrado.apply(8));
        System.out.println("Fin Ejemplos de funciones puras");
    }

}
