package com.jlv.java.functional.immutable;

import java.util.LinkedList;
import java.util.List;

/**
 * 1 – Se le agrega el keyword final a la clase que queremos hacer inmutable. Con esto logramos que nadie pueda extender de ella y cambiar su comportamiento.
 * 2 – Establecemos todos sus atributos como final.
 * 3 – Declaramos un constructor que exige todos los atributos para generar un objeto
 * 4 – Cuando tengamos que retornar un objeto, en lugar de retornar una referencia a la instancia originar, lo que hacemos es retornar una copia.
 */
public final class InmutabilidadPerson {
    private final String nombre;
    private final String apellido;
    private final List<String> emails;

    public InmutabilidadPerson(String nombre, String apellido, List<String> emails) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.emails = emails;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public final List<String> getEmails() {
        return new LinkedList<>(emails);
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
