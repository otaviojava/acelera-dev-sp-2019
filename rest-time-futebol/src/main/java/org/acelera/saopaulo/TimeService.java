package org.acelera.saopaulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Component
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public int getTotalDeJogadores(Long id){
        return timeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found. Time não encontrado."))
                .getJogadores().size();
    }

    public List<Jogador> getJogadoresFantastico(Long id){
        return timeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found. Time não encontrado."))
                .getJogadores().stream()
                .filter(j -> j.getGols()>= 3)
                .collect(Collectors.toList());
    }

    public Map<Posicao, List<Jogador>> getJogadoresPorPosicao(Long id, Posicao posicao){
        return timeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found. Time não encontrado."))
                .getJogadores().stream()
                .filter(f -> f.getPosicao().equals(posicao))
                .collect(groupingBy(Jogador::getPosicao));
    }

    public Map<Posicao, List<Jogador>> getJogadoresPorPosicao(Long id){
        return timeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found. Time não encontrado."))
                .getJogadores().stream()
                .collect(groupingBy(Jogador::getPosicao));
    }

    public Jogador getArtilheiro(Long id){
        Comparator<Jogador> maiorGols = Comparator.comparing(Jogador::getGols);
        Comparator<Jogador> peloNome= Comparator.comparing(Jogador::getNome);
        Optional<Jogador> artilheiro = timeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found. Time não encontrado."))
                .getJogadores().stream()
                .max(maiorGols.thenComparing(peloNome));

        return artilheiro
                .orElseThrow(() -> new IllegalStateException("Sempre deve ter um artilheiro no time"));
    }

    public List<Jogador> getJogadoresOrdenadosPorGols(Long id){
        return timeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found. Time não encontrado."))
                .getJogadores().stream()
                .sorted(Comparator.comparing(Jogador::getGols).reversed())
                .collect(Collectors.toList());
    }
}
