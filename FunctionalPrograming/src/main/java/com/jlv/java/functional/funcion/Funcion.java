package com.jlv.java.functional.funcion;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Funcion {

    public static void main(String[] args) {
        Funcion func = new Funcion();
        func.funcionPura();
        func.imprimirLineasSeparadoras();
        func.funcionOrdenMayor();
        func.ejemploBiFunction();
    }

    //Ejemplos de funciones puras
    private void funcionPura() {
        System.out.println("Inicio Ejemplos de funciones puras");
        Function<Integer,Integer> calcularCuadrado = calcularCuadrado();
        System.out.println("\tEl resultado de aplicar la función calcularCuadrado a 8 es:  " + calcularCuadrado.apply(8));
        System.out.println("Fin Ejemplos de funciones puras");
    }

    private void funcionOrdenMayor(){
        System.out.println("Inicio Ejemplos de funciones de orden mayor");
        Function<Integer,Integer> procesoCuadrado = this.calcularCuadrado();
        procesarCalculo(procesoCuadrado, 8);
        System.out.println("Fin Ejemplos de funciones de orden mayor");
    }

    private void procesarCalculo(Function<Integer,Integer> proceso, Integer valor){
        BiFunction<Function,Integer,Integer> procesoCalculo =  new BiFunction<Function,Integer, Integer>(){
            public Integer apply(Function o, Integer valor) {
                return (Integer) o.apply(valor);
            }
        };
        System.out.println("\tValor calculado " + procesoCalculo.apply(proceso,valor));
    }

    private Function calcularCuadrado(){
        return new Function<Integer,Integer>(){
            @Override
            public Integer apply(Integer o) {
                return o * o;
            }
        };
    }

    private void imprimirLineasSeparadoras(){
        System.out.println("*****");
        System.out.println("*****");
    }

    private void ejemploBiFunction(){
        BiFunction<String, Integer, String> formateador = new BiFunction<String, Integer, String>(){
            @Override
            public String apply(String texto, Integer espacios){
                return String.format("%" + espacios + "s",texto);
            }
        };
        System.out.println(formateador.apply("Formateador",20));
    }

}
