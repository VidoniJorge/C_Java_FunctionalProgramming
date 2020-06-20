package com.jlv.java.functional.immutable;

import java.util.List;

public class MutablePerson {
    private String nombre;
    private String apellido;
    private List<String> emails;

    public MutablePerson() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "MutablePerson{" +
                "\nnombre= " + this.nombre +
                "\napellido= " + this.apellido +
                "\nemails= " + emails.toString() +
                "\n}";

    }
}
