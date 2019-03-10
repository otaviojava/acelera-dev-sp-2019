package org.acelera.saopaulo.revisao;

import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) {
        Operacao operacao = new Soma();
        operacao.imprimirOperacao(1,3);

        List<BaseTrabalhador> trabalhadores = new ArrayList<>();
        trabalhadores.add(new Programdor("Ze", "SP"));
        trabalhadores.add(new Advogado("Osvaldo", "SP"));

        for (BaseTrabalhador trabalhador : trabalhadores) {
            trabalhador.trabalhar();
        }

    }
}
