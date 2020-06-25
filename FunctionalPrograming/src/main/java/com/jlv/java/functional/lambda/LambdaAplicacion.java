package com.jlv.java.functional.lambda;

import com.jlv.java.functional.operador_referencia.OperadorReferenciaAplicacion;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

public class LambdaAplicacion {
    public static void main(String[] args) {
        LambdaAplicacion la = new LambdaAplicacion();
        la.ejemploUno();
        la.ejemploCalculoCuaradonSinLambda();
        la.ejemploCalculoCuaradonConLambda();

    }

    private void ejemploUno(){
        List<String> cursos = OperadorReferenciaAplicacion.getList("Java","Functional");
        cursos.forEach(curso -> System.out.println(curso));
        userZero(()->2);
        Function<Integer,Integer> f = (a) -> a + a;
        System.out.println(LocalDate.now());
    }

    static void userZero(ZeroArgumentos zeroArgumentos){

    }

    @FunctionalInterface
    interface ZeroArgumentos{
        int get();
    }

    private void ejemploCalculoCuaradonConLambda(){
        Function<Integer,Integer> cuadrado = (x) -> x * x;
        System.out.println("El cuadrado de x calculado con lambda es : " + cuadrado.apply(8));
    }

    private void ejemploCalculoCuaradonSinLambda(){
        Function<Integer,Integer> cuadrado = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        System.out.println("El cuadrado de x calculado sin lambda es : " + cuadrado.apply(8));
    }
}
