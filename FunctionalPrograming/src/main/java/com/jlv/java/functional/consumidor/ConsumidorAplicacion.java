package com.jlv.java.functional.consumidor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumidorAplicacion {

    public static void main(String[] args) {
        Consumer<String> consumidor = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumidor.accept("Inicio de las pruebas del consumidor");

        List<String> nombres = new ArrayList<>();
        nombres.add("Pepe");
        nombres.add("Alberto");
        nombres.add("Juan");
        nombres.forEach(consumidor);
    }
}
