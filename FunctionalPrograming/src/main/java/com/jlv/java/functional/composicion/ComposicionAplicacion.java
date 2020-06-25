package com.jlv.java.functional.composicion;

import java.util.function.Function;

public class ComposicionAplicacion {
    // explicar este tema, esta muy copado.
    public static void main(String[] args) {

        Function<Integer,Integer> multiplyBy3 = x -> {
            System.out.println("Multiplicando x : " + x + " por 3");
            return x * 3;
        };

        Function<Integer,Integer> addOne = y -> {
            System.out.println("Le agregate 1 a: " + y);
            return y + 1;
        };

        Function<Integer, Integer> square = x -> {
                    System.out.println("Estoy elevando " + x + " al cuadrado");
                    return x * x;
                };

        // Creo una función con el compose
        Function<Integer,Integer> add1MultiplyBy3 = multiplyBy3.compose(addOne);
        // Creo una función con el andThen
        Function<Integer, Integer> andSquare = add1MultiplyBy3.andThen(square);

        System.out.println(andSquare.apply(5));
    }
}
