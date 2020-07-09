# Job-Search

En este proyecto buscamos aplicar lo visto de programación funcional con java.
La aplicación **job-search**, es una app de línea de comando la cual se conecta a la API [Jobs-github](https://jobs.github.com/api) y lista las ofertas de trabajos actuales.

## Opciones de línea de comando

> job-search java

> job-search java --location Mexico

> job-search java --page 2

> job-search java --full-time

> job-search java --markdown

## Dependencias

JCommander: Esta librería toma los argumentos que se le pasan por consola y los convierte a objetos de Java.
Feign Core: Esta librería hace peticiones web.
Feign Gson: Esta librería convierte los JSON que recibe de la petición a objetos y clases en Java.