package com.jlv.java.functional.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * Clase usada por JCommander para validar argumentos.
 * <p>
 * En nuestro caso la usamos para validar que el skill solicitiado (keyword) sea únicamente  letras y números.
 */
public class CLIKeywordValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        if(!value.matches("^[a-zA-Z]+[0-9]*$")){
            System.err.println(("El criterio de busqueda no es valido"));
            throw new ParameterException("Unicamente Letras y números");
        }
    }
}
