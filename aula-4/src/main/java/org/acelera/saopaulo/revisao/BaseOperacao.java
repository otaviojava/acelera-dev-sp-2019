package org.acelera.saopaulo.revisao;

import java.util.ArrayList;
import java.util.List;

public  abstract class BaseOperacao implements Operacao {

    protected static double PI = Math.PI;

    protected List<Integer> resultados = new ArrayList<>();

    protected abstract int operar(int a, int b) ;

    public void imprimirOperacao(int a, int b) {
        imprimir(operar(a, b));
    }

    protected void imprimir(int resultado) {
        resultados.add(resultado);
        System.out.println("O resultado eh " + resultado);
    }
}
