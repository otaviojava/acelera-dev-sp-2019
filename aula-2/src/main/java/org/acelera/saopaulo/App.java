package org.acelera.saopaulo;

public class App {

    public static void main(String[] args) {
        PiadaRuim piadaRuim = new PiadaRuim();
        System.out.println(piadaRuim.contar());
        piadaRuim.variavel = "novo valor";
        System.out.println(PiadaRuim.variavel);

        PiadaRuimMesmo heranca = new PiadaRuimMesmo();
        System.out.println(heranca.contar());
        PiadaRuim.variavel = "mudando o valor";
        System.out.println(PiadaRuim.variavel);
        TipoPiada.BOA.reagir();
    }
}
