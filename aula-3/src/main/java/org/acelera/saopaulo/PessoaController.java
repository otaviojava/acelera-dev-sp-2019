package org.acelera.saopaulo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    private Map<String, Pessoa> data = new HashMap<>();

    //pessoas no corpo informacao
    //pessoas?nome=Otavio&idade=18&senha=123123&
    @PostMapping
    public void inserir(@RequestBody Pessoa pessoa) {
        data.put(pessoa.getNome(), pessoa);
    }

    @PutMapping(value = "/{nome}", produces = "application/json")
    public void atualizar(String nome, Pessoa pessoa) {
        data.put(nome, pessoa);
    }

    @GetMapping(value = "/{nome}", produces = "application/json")
    public Pessoa recuperar(String nome) {
        return data.get(nome);
    }

    @DeleteMapping(value = "/{nome}", produces = "application/json")
    public Pessoa remover(String nome) {
        return data.remove(nome);
    }
}
