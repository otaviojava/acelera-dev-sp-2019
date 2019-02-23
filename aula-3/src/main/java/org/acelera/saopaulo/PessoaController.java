package org.acelera.saopaulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepoitory pessoaRepoitory;

    //http://localhost:8080/h2-console/
    //pessoas no corpo informacao
    //pessoas?nome=Otavio&idade=18&senha=123123&
    @PostMapping
    public void inserir(@RequestBody Pessoa pessoa) {
        pessoaRepoitory.save(pessoa);
    }

    @PutMapping(value = "/{nome}", produces = "application/json")
    public void atualizar(@PathVariable String nome,@RequestBody Pessoa pessoa) {
        //devo validar isso
        //se nao exister, retorno 404
        pessoaRepoitory.save(pessoa);
    }

    @GetMapping(value = "/{nome}", produces = "application/json")
    public Pessoa recuperar(@PathVariable String nome) {
        Optional<Pessoa> pessoa = pessoaRepoitory.findById(nome);
        return pessoa.orElseThrow(() ->new RuntimeException("Resource not found deve retornar 404"));
    }

    @DeleteMapping(value = "/{nome}", produces = "application/json")
    public void remover(@PathVariable String nome) {
        Optional<Pessoa> pessoa = pessoaRepoitory.findById(nome);
        pessoaRepoitory.delete(pessoa.orElseThrow(() ->new RuntimeException("")));
    }
}
