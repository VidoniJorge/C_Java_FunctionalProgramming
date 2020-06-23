package com.jlv.java.functional.funcion;

@FunctionalInterface
public interface TriFunction<T,U,V,R> {
    R apply(T t, U u, V v);
}
