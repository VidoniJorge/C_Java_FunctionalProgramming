package com.jlv.java.functional.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {
    @Parameter(
            required = true,
            descriptionKey = "KKEYWORD",
            description = "KKEYWORD",
            validateWith = CLIKeywordValidator.class
    )
    private String keyword;
    @Parameter(
            names = {"--location","-l"},
            description = "Cada búsqueda puede incluir una ubicación."
    )
    private String location;
    @Parameter(
            names = {"--page","-p"},
            description = "La API devuelve 50 resultados, usa un numero para pagina."
    )
    private int page =0;
    @Parameter(
            names = {"--full-time"},
            description = "Agregar si queremos trabajo de tiempo completo."
    )
    private boolean isFullTime = false;
    @Parameter(
            names = {"--markdown"},
            description = "Obtener los resultados en markdown."
    )
    private boolean isMarkdown = false;
    @Parameter(
            names = {"--help"},
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Mostrar esta ayuda"
    )
    private boolean isHelp;

    /**
     * Constructor default para permitir que solo clases en el paquete, puedan crear objetos
     * de esta clase.
     * De esta manera obligamos a que la construcción se haga mediante funciones públicas o
     * builders.
     * <p>
     * Las instancias deberán crearse mediante: CLIArguments#newInstance
     */
    CLIArguments(){

    }

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    /**
     * Esta función es equivalente a CLIArguments::new, sin embargo, si en el futuro queremos agregar
     * parámetros adicionales, podemos limitar la manera de construir objetos mediante esta función.
     */
    public static CLIArguments newInstance(){
        return new CLIArguments();
    }
}
