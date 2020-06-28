package com.jlv.java.functional.jobsearch.funtions;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public interface CommanderFunctions {

    /**
     * JCommander permite generar opciones de terminal de cualquier clase, por eso el primer parametro es de tipo Object.
     *
     * @param object Clase de la cual se generarán los argumentos de JCommander
     * @return una instancia de JCommander. Idealmente con CLIArguments como objeto pasado.
     */
    static JCommander buildCommander(Object object) {
        return JCommander
                .newBuilder()
                .addObject(object)
                .build();
    }

    /**
     * Con esta función, facilitamos crear una configuración inicial de JCommander, pidiendo el nombre del
     * programa y un Supplier de tipo T para los argumentos. Así podemos usar alguna función que nos devuelva
     * un objeto que funcione como argumentos de JCommander.
     *
     * @param name              nombre que se mostrara en el CLI
     * @param argumentsSupplier una función que devuelva un objeto de argumentos de JCommander
     * @param <T>               Tipo que se usara para los argumentos
     * @return una instancia de {@link JCommander} ya configurada con el nombre y los argumentos.
     */
    public static <T> JCommander buildCommanderWithName(String name, Supplier<T> argumentSupplier){
        JCommander jCommander = buildCommander(argumentSupplier.get());
        jCommander.setProgramName(name);
        return jCommander;
    }

    /**
     * Función utilizada para tomar los datos de JCommander, los argumentos esperados y en caso de que algo falle,
     * una función con el JCommander que genero el error.
     */
    public static Optional<List<Object>> parseArguments(
            JCommander jCommander,
            String[] arguments,
            OnCommandError onCommandError){
        try{
            jCommander.parse(arguments);
            return Optional.of(jCommander.getObjects());
        } catch(ParameterException | ArrayIndexOutOfBoundsException paramEx){
            onCommandError.onError(jCommander);
        }
        return Optional.empty();
    }

    @FunctionalInterface
    interface OnCommandError {
        void onError(JCommander jCommander);
    }
}
