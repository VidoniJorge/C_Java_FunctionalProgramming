package com.jlv.java.functional.jobsearch;

import com.beust.jcommander.JCommander;
import com.jlv.java.functional.jobsearch.api.APIJobs;
import com.jlv.java.functional.jobsearch.api.JobPosition;
import com.jlv.java.functional.jobsearch.cli.CLIArguments;
import com.jlv.java.functional.jobsearch.cli.CLIFunctions;

import java.util.*;
import java.util.stream.Stream;

import static com.jlv.java.functional.jobsearch.api.ApiFunctions.buildAPI;
import static com.jlv.java.functional.jobsearch.funtions.CommanderFunctions.buildCommanderWithName;
import static com.jlv.java.functional.jobsearch.funtions.CommanderFunctions.parseArguments;

public class JobSearch {
    public static void main(String[] args) {
        //Creación de nuestro CLI con JCommander
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

        //Obtenemos las opciones que se le dieron a JCommander
        Stream<CLIArguments>  streamOfCli =  parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj -> (CLIArguments)obj) ;

        //Tomamos nuestro Stream y obtenemos las opciones que se dieron en el CLI
        Optional<CLIArguments> cliArgumentsOptinal = streamOfCli
                //Solo nos interesan los casos donde no sea la solicitud de ayuda
                .filter(cli -> !cli.isHelp())
                //Y que contengan un keyword, en otros caso no tenemos que buscar
                .filter(cli -> cli.getKeyword() != null)
                .findFirst();

        //Si el Optional tiene un dato, lo convertimos a Map<String,Object>
        cliArgumentsOptinal.map(CLIFunctions::toMap)
                //Convertimos el Map en un request
                .map(JobSearch::executeRequest)
                //Aún seguimos operando sobre un Optional… en caso de que no hubiera datos generamos un stream vacío
                .orElse(Stream.empty())
                //Imprimos los datos por pantalla.
                .forEach(JobSearch::print);


    }

    private static void print(JobPosition jobPosition){
        System.out.println("*****************************");
        System.out.println("*****************************");
        System.out.println(jobPosition);
    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params){
        APIJobs api = buildAPI(APIJobs.class,"https://jobs.github.com");
        return Stream.of(params)
                .map(api::jobs)
                .flatMap(Collection::stream);
    }
}
