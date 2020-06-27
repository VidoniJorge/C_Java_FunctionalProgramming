package com.jlv.java.functional.optional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Opcional {

    public static void main(String[] args) {
        Opcional ops = new Opcional();
        ops.ejemploValidarOptionalVacio(ops.ejemploCrearOpcional());
        ops.ejemploValidarOptionalVacio(ops.ejemploCrearOpcionalEmpty());
        ops.ejemploIfPresent();
        ops.ejemploMapVsFlatMap();
        ops.ejemploOrLeseGet();




        /*
        Optional<List<String>> names = getNames();
        if(names.isPresent()){

        }


        //names.map();
        //names.flatMap()
        names.map( x ->{
            return x;
        });
        names.flatMap();
        Optional<String> valuablePlayer = valuablePlayer();
        String valores = valuablePlayer.orElseGet(()->"Get Player");
        //Optional.ofNullable() valor que puede tener nullo, optional hace todo el trabajao
*/
    }

    private Optional<String> ejemploCrearOpcional(){
        System.out.println("************ Ejemplo: Crear opcional");
        return Optional.of("Pepe");
    }

    private Optional<String> ejemploCrearOpcionalEmpty(){
        System.out.println("************ Ejemplo : Crear opcional vacío");
        return Optional.empty();
    }

    private void ejemploValidarOptionalVacio(Optional<String> op){
        System.out.println("************ Ejemplo : Validar si el optional vacío");
        if(op.isPresent())
            System.out.println("No estoy vacío y su valor es: " + op.get());
        else
            System.out.println("Estoy vacío");
    }

    private void ejemploIfPresent(){
        System.out.println("************ Ejemplo : ifPresent");
        Optional<List<String>> names = getNames();
        names.ifPresent(values -> values.forEach(System.out::println));
    }

    private void ejemploOrLeseGet(){
        System.out.println("************ Ejemplo : ejemploOrLeseGet");
        Optional<String> names = ejemploCrearOpcional();
        System.out.println(names.orElseGet(() -> "Valor por defecto"));
    }

    private Optional<List<String>> getNames(){
        List<String> names = new LinkedList<String>();
        names.add("Juan");
        names.add("Luis");
        names.add("Alberto");
        return Optional.of(names);
    }

    static Optional<String> valuablePlayer(){
        //Optional.ofNullable()
        try{
            Optional.of("ooo");
        } catch (Exception e){

        }
        return Optional.empty();
    }

    private void ejemploMapVsFlatMap(){
        System.out.println("************ Ejemplo : Map vs FlatMap");
        Optional<String> nombre = Optional.of("Pepe");
        System.out.println("Map " + nombre.map(x -> {
            System.out.println(x);
            return x;
        }));

        System.out.println("flatMap : " + nombre.flatMap( x ->{
            System.out.println(x);
            return Optional.of(x);})
        );

        Optional<Optional<String>> nombreOp = Optional.of(Optional.of("Pepe"));
        System.out.println("map : " + nombreOp.map( x -> {
            System.out.println(x.get());
            return x;
        }));

        System.out.println("flatMap : " + nombreOp.flatMap(x -> {
            System.out.println(x.get());
            return x;
        }));
    }
}
