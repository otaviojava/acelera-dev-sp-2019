package org.acelera.saopaulo;

@FunctionalInterface
public interface Operacao<T,U> {
    int operar(T a, U b);
}
