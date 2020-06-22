package com.jlv.java.functional.proveedor;

import java.util.Random;
import java.util.function.Supplier;

public class ProveedorAplicacion {
    public static void main(String[] args) {
        Supplier<Integer> notas = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        };

        System.out.println(notas.get());
        System.out.println(notas.get());
        System.out.println(notas.get());
        System.out.println(notas.get());
    }
}
