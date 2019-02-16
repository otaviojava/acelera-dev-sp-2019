package org.acelera.saopaulo;

public class PessoaApp {

    public static void main(String[] args) {
        Pessoa pessoa = Pessoa.builder()
                .withNome("Otavio")
                .withSobreNome("Santana")
                .withIdade(23)
                .withCidade("Salvador")
                .build();


    }
}
