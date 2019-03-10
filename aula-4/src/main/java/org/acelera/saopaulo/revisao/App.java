package org.acelera.saopaulo.revisao;

import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) {
        List<BaseTrabalhador> trabalhadores = new ArrayList<>();
        trabalhadores.add(new Programdor("Ze", "SP"));
        trabalhadores.add(new Advogado("Osvaldo", "SP"));

        for (BaseTrabalhador trabalhador : trabalhadores) {
            trabalhador.trabalhar();
        }

    }
}
