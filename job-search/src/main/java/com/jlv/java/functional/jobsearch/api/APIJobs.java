package com.jlv.java.functional.jobsearch.api;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

/**
 * Esta interfaz será usada por Feign para hacer las peticiones a la API de github.
 */
@Headers("Accept: application/json")
public interface APIJobs {
    @RequestLine("GET /positions.json")
    List<JobPosition> jobs(@QueryMap Map<String, Object> query);
}
