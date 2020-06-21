package com.jlv.java.functional.predicado;

import java.util.function.Predicate;

public class PredicadoAplicacion {

    public static void main(String[] args) {
        Predicate<Estudiante> aprobo = new Predicate<Estudiante>() {
            @Override
            public boolean test(Estudiante estudiante) {
                return estudiante.getCalificacion()>7;
            }
        };
        Estudiante est = new Estudiante("Lopes",8);
        System.out.println("El estudiante " + est.getNombre() +" aprobó: " + aprobo.test(est));
        Estudiante est2 = new Estudiante("Luis",6);
        System.out.println("El estudiante " + est2.getNombre() +" aprobó: " + aprobo.test(est2));
    }

}
