package org.acelera.saopaulo;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Collections;

public class App {

    public static void main(String[] args) {
        PiadaRuim piadaRuim = new PiadaRuim();
        System.out.println(piadaRuim.contar());
        piadaRuim.variael = "novo valor";
        System.out.println(PiadaRuim.variael);

        PiadaRuimMesmo heranca = new PiadaRuimMesmo();
        System.out.println(heranca.contar());
        PiadaRuim.variael = "mudando o valor";
        System.out.println(PiadaRuim.variael);
        TipoPiada.BOA.reagir();
    }
}
