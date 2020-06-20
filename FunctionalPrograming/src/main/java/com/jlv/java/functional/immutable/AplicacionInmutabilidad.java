package com.jlv.java.functional.immutable;

import java.util.ArrayList;
import java.util.List;

public class AplicacionInmutabilidad {
    public static void main(String[] args) {
        //Ejemplo Mutable
        List<String> emails = new ArrayList<>();
        emails.add("PEPE@gmail.com");

        MutablePerson persona = new MutablePerson();
        persona.setApellido("PEPE");
        persona.setNombre("LUCAS");
        persona.setEmails(emails);

        imprimir(persona);

        // Ejemplo Inmutable
        List<String> emails2 = new ArrayList<>();
        emails2.add("PEPE@gmail.com");
        InmutabilidadPerson persona2 = new InmutabilidadPerson("PEPE","LUCAS",emails2);
        imprimir2(persona2);


    }

    public static void imprimir(MutablePerson persona){
        System.out.println("Ejemplo Mutable");
        List<String> emails = new ArrayList<>();
        persona.getEmails().add("PEPE2@gmail.com");
        persona.getEmails().add("PEPE3@gmail.com");
        System.out.println(persona.toString());
    }

    public static void imprimir2(InmutabilidadPerson persona){
        System.out.println("Ejemplo Inmutable");
        List<String> emails = new ArrayList<>();
        persona.getEmails().add("PEPE2@gmail.com");
        persona.getEmails().add("PEPE3@gmail.com");
        System.out.println(persona.toString());
    }
}
