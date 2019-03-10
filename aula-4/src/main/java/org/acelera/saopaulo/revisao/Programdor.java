package org.acelera.saopaulo.revisao;

public class Programdor extends BaseTrabalhador {

    Programdor(String nome, String cidade) {
        super(nome, cidade);
    }

    @Override
    public String getSalario() {
        return "banana";
    }

    @Override
    public void reclamarDaVida() {
        System.out.println("Assistindo GoT");
    }
}
