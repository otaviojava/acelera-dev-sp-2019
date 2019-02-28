package org.acelera.saopaulo.soccer.service;

import org.acelera.saopaulo.soccer.builder.JogadorDtoBuilder;
import org.acelera.saopaulo.soccer.dto.JogadorDto;
import org.acelera.saopaulo.soccer.entity.Jogador;
import org.acelera.saopaulo.soccer.repository.JogadorRepository;
import org.acelera.saopaulo.soccer.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.xml.ws.WebServiceException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private TimeRepository timeRepository;

    public void adicionaJogador(JogadorDto jogadorDto) {
        // Verificar se jogador ja existe antes de adicionar
        try{
            getJogador(jogadorDto.getNome());
            throw new IllegalArgumentException("Tentando adicionar Jogador que já existe");

        }catch (EntityNotFoundException e){
            Jogador novoJogador = new Jogador();
            novoJogador.setNome(jogadorDto.getNome());
            novoJogador.setCidade(jogadorDto.getCidade());
            novoJogador.setPais(jogadorDto.getPais());
            novoJogador.setPosicao(jogadorDto.getPosicao());
            novoJogador.setGols(jogadorDto.getGols());
            novoJogador.setTime(timeRepository.findById(jogadorDto.getTime())
                    .orElseThrow(() -> new EntityNotFoundException("Time nao encontrado")));
            jogadorRepository.save(novoJogador);
        }
    }

    public JogadorDto getJogador(String nome) {
        return JogadorDtoBuilder.buildFromEntity(
                jogadorRepository.findById(nome)
                        .orElseThrow(() -> new EntityNotFoundException("Jogador nao encontrado"))
        );
    }

    public void removeJogador(String nome) {
        //Verificar se jogador existe antes de deletar
        getJogador(nome);

        jogadorRepository.deleteById(nome);
    }

    public List<JogadorDto> getJogadores() {
        List<JogadorDto> jogadores = new ArrayList<>();
        jogadorRepository.findAll().forEach(j -> jogadores.add(JogadorDtoBuilder.buildFromEntity(j)));
        return jogadores;
    }

    public JogadorDto atualizaJogador(String nome, JogadorDto jogadorDto) {
        //Verificar se jogador existe antes de atualizar
        getJogador(nome);

        Jogador jogador = jogadorRepository.findById(nome)
                .orElseThrow(() -> new EntityNotFoundException("Jogador nao encontrado"));
        jogador.setNome(jogadorDto.getNome());
        jogador.setCidade(jogadorDto.getCidade());
        jogador.setGols(jogadorDto.getGols());
        jogador.setPais(jogadorDto.getPais());
        jogador.setPosicao(jogadorDto.getPosicao());
        jogador.setTime(timeRepository.findById(jogadorDto.getTime())
                .orElseThrow(() -> new EntityNotFoundException("Time nao encontrado")));

        return JogadorDtoBuilder.buildFromEntity(
                jogadorRepository.save(jogador)
        );
    }
}
