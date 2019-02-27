package org.acelera.saopaulo.soccer.controller;

import org.acelera.saopaulo.soccer.dto.JogadorDto;
import org.acelera.saopaulo.soccer.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping("/adiciona")
    public void adicionaJogador(@RequestBody JogadorDto jogadorDto) {
        jogadorService.adicionaJogador(jogadorDto);
    }

    @PutMapping("/{nome}")
    public JogadorDto atualizaJogador(@PathVariable String nome, @RequestBody JogadorDto jogadorDto) {
        return jogadorService.atualizaJogador(nome, jogadorDto);
    }

    @GetMapping("/{nome}")
    public JogadorDto buscaJogador(@PathVariable String nome) {
        return jogadorService.getJogador(nome);
    }

    @DeleteMapping("/{nome}")
    public void removeJogador(@PathVariable String nome) {
        jogadorService.removeJogador(nome);
    }

    @GetMapping("/all")
    public List<JogadorDto> buscaJogadores() {
        return jogadorService.getJogadores();
    }
}
