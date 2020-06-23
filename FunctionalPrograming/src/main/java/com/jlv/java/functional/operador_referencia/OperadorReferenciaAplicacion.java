package com.jlv.java.functional.operador_referencia;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class OperadorReferenciaAplicacion {

    public static void main(String[] args) {
        List<String> profesore = getList("Nicolas", "Juan", "Zulema");

        Consumer<String> printer = new Consumer<String>(){
            @Override
            public void accept(String text ){
                System.out.println(text);
            }
        };

        System.out.println("*** Funcion Operador Referencia");
        profesore.forEach(printer);
        System.out.println("*** Operador Referencia");
        profesore.forEach(System.out::println);
    }

    public static <T> List<T> getList(T... elements){
        return Arrays.asList(elements);
    }
}
