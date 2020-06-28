package com.jlv.java.functional.jobsearch.api;

import feign.Feign;
import feign.gson.GsonDecoder;

public interface ApiFunctions {
    /**
     * Para construir la llamada fon Feign, necesitamos generar un cliente de Feign,
     * esconder que internamente este es el cliente que se usa, nos facilita hacer fácil
     * el reemplazo de la librería para http en el futuro.
     *
     * @param api una Class de tipo T para construir nuestra api
     * @param url la URL base donde estaremos haciendo los requests
     * @param <T> el tipo de API que construiremos
     * @return una instancia de T para usar como cliente de API
     */
    static <T> T buildAPI(Class<T> api, String url){
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(api, url);
    }
}
