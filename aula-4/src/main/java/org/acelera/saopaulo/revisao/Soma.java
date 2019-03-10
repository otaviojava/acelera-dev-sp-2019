package org.acelera.saopaulo.revisao;

public class Soma extends BaseOperacao {

    @Override
    protected int operar(int a, int b) {
        return a + b;
    }

    @Override
    public String toString() {
        return "resultados: " + resultados;
    }
}
