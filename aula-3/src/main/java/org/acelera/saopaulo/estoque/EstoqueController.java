package org.acelera.saopaulo.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class EstoqueController {

    @Autowired
    ProdutoRepository repository;

    @PostMapping
    public void adicionaProduto(@RequestBody Produto produto) {
        repository.save(produto);
    }

    @PutMapping(value = "/{nome}", produces = "application/json")
    public void atualizaProduto(@PathVariable String nome, @RequestBody Produto produto) {
        repository.save(produto);
    }

    @GetMapping(value = "/{nome}", produces = "application/json")
    public Produto recuperaProduto(@PathVariable String nome) {
        return repository.findById(nome).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @GetMapping
    public List<String> recuperaProdutos() {
        List<String> nomeProdutos = new ArrayList<>();
        repository.findAll().forEach(produto -> nomeProdutos.add(produto.getNome()));
        return nomeProdutos;
    }

    @DeleteMapping(value = "/{nome}", produces = "application/json")
    public void deletaProduto(@PathVariable String nome) {
        repository.deleteById(nome);
    }

}
