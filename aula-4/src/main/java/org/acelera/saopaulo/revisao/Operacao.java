package org.acelera.saopaulo.revisao;

import java.util.ArrayList;
import java.util.List;

public interface Operacao {

    List<Integer> resultados = new ArrayList<>();

    void imprimirOperacao(int a, int b);
}
