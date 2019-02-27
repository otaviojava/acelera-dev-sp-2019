package org.acelera.saopaulo.futebol.service;

import org.acelera.saopaulo.futebol.builder.JogadorDtoBuilder;
import org.acelera.saopaulo.futebol.dto.JogadorDto;
import org.acelera.saopaulo.futebol.entity.Jogador;
import org.acelera.saopaulo.futebol.repository.JogadorRepository;
import org.acelera.saopaulo.futebol.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private TimeRepository timeRepository;

    public void adicionaJogador(JogadorDto jogadorDto) {
        Jogador novoJogador = new Jogador();
        novoJogador.setNome(jogadorDto.getNome());
        novoJogador.setCidade(jogadorDto.getCidade());
        novoJogador.setPais(jogadorDto.getPais());
        novoJogador.setPosicao(jogadorDto.getPosicao());
        novoJogador.setGols(jogadorDto.getGols());
        novoJogador.setTime(timeRepository.findById(jogadorDto.getTime()).orElseThrow(() -> new EntityNotFoundException("Time nao encontrado")));
        jogadorRepository.save(novoJogador);
    }

    public JogadorDto getJogador(String nome) {
        return JogadorDtoBuilder.buildFromEntity(
                jogadorRepository.findById(nome).orElseThrow(() -> new EntityNotFoundException("Jogador nao encontrado"))
        );
    }

    public void removeJogador(String nome) {
        jogadorRepository.deleteById(nome);
    }

    public List<JogadorDto> getJogadores() {
        List<JogadorDto> jogadores = new ArrayList<>();
        jogadorRepository.findAll().forEach(j -> {
            jogadores.add(JogadorDtoBuilder.buildFromEntity(j));
        });
        return jogadores;
    }
}
