package com.jlv.java.functional.jobsearch.cli;

import java.util.HashMap;
import java.util.Map;

public class CLIFunctions {
    /**
     * Función que tomara los argumentos del CLI y los convertirá en algo que se pueda
     * usar en la API de github.
     */
    public static Map<String,Object> toMap(CLIArguments cliArguments){
        Map<String, Object> params = new HashMap<>();
        params.put("description",cliArguments.getKeyword());
        params.put("locacion",cliArguments.getLocation());
        params.put("full_time",cliArguments.isFullTime());
        params.put("page",cliArguments.getPage());

        if(cliArguments.isMarkdown())
            params.put("markdown",true);
        return params;
    }
}
