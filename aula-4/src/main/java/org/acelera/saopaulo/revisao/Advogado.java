package org.acelera.saopaulo.revisao;

public class Advogado extends BaseTrabalhador {

    protected Advogado(String nome, String cidade) {
        super(nome, cidade);
    }

    @Override
    protected String getSalario() {
        return "espera o processo pq causa esta ganha";
    }

    @Override
    public void reclamarDaVida() {
        System.out.println("Pede a alma do Client, para `defender a justica`");
    }
}
