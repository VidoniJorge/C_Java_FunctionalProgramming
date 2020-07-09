package com.jlv.java.functional.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsAplicacion {
    public static void main(String[] args) {
        //List<String> cursos = getList("Java", "FrontEnd", "Backend", "Fullstack");

        //Stream<String> cursesStream = Stream.of("Java", "FrontEnd", "Backend", "Fullstack");
        StreamsAplicacion sa = new StreamsAplicacion();
        sa.testFlatMap();
    }

    static <T> List<T> getList(T ... names){
        return Arrays.asList(names);
    }

    private void testFlatMap(){
        List<List<String>> ciudades = getCiudades();
        ciudades.stream().flatMap(p->
                p.stream()
            ).forEach(p-> System.out.println(p));

    }

    private List<List<String>> getCiudades() {
        List<String> ciudadesCapital = getList("caballito","flores","ramos");
        List<String> ciudadesCordoba = getList("nueva cordoba","alta cordoba","villa allende");

        List<List<String>> ciudades = new ArrayList<List<String>>();

        ciudades.add(ciudadesCapital);
        ciudades.add(ciudadesCordoba);

        return ciudades;
    }
}
