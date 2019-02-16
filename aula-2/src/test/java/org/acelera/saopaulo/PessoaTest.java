package org.acelera.saopaulo;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTest {


    @Test
    public void deveCriarUmaInstancia() {
        Pessoa pessoa = Pessoa.builder()
                .withNome("Otavio")
                .withSobreNome("Santana")
                .withIdade(23)
                .withCidade("Salvador")
                .build();

        assertNotNull(pessoa);
        assertEquals("Otavio", pessoa.getNome());

    }

    @Test
    public void nomeDeveSerObrigatorio() {
        String nome = null;

        nome.toString();
        assertThrows(NullPointerException.class,
                () -> {
                    Pessoa pessoa = Pessoa.builder()
                            .withNome(null).build();
                });


    }
}
