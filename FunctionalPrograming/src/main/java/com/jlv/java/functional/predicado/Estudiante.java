package com.jlv.java.functional.predicado;

public class Estudiante {
    private String nombre;
    private double calificacion;

    public Estudiante(String nombre, double calificacion) {
        this.calificacion = calificacion;
        this.nombre = nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public String getNombre() {
        return nombre;
    }
}
