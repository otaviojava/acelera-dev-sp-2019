package org.acelera.saopaulo;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertAll;


class TimeTest {

    @Mock
    private TimeRepository timeRepository;

    @InjectMocks
    private TimeService timeService;

    @BeforeEach
    void setup(){
        Jogador allejo = mock("Allejo", 1000, Posicao.ATAQUE);
        Jogador gomez = mock("Gomez", 2, Posicao.ATAQUE);
        Jogador rivaldo = mock("Rivaldo", 23, Posicao.ATAQUE);
        Jogador neymar = mock("Neymar", 33, Posicao.ATAQUE);
        Jogador alface = mock("Alface", -1, Posicao.GOLEIRO);
        Jogador dida = mock("Dida", 5, Posicao.GOLEIRO);
        Jogador dasilva = mock("DaSilva", 0, Posicao.GOLEIRO);
        Jogador vincento = mock("Vincento", 2, Posicao.DEFESA);
        Jogador paco = mock("Paco", 1, Posicao.DEFESA);

        List<Jogador> jogadores = Arrays.asList(allejo, gomez, rivaldo, neymar, alface, dida, dasilva, vincento, paco);

        Time brasil = mockTime("Brasil", jogadores, 1L);

        MockitoAnnotations.initMocks(this);

        Mockito.when(timeRepository.findAll()).thenReturn(Arrays.asList(brasil));
        Mockito.when(timeRepository.findById(1L)).thenReturn(Optional.of(brasil));
    }

    @Test
    void deveRetornarTotalJogadores(){
        int quantidade = timeService.getTotalDeJogadores(1L);
        Assertions.assertEquals(9, quantidade);
    }

    @Test
    void deveRetornarJogadoresFantastico(){
        List<Jogador> jogadoresFantastico = timeService.getJogadoresFantastico(1L);

        assertThat(jogadoresFantastico, containsInAnyOrder(matchByNome("Allejo", "Rivaldo", "Neymar", "Dida")));
    }

    @Test
    void deveAgruparPorPosicao(){

        Map<Posicao, List<Jogador>> jogadoresPorPosicao = timeService.getJogadoresPorPosicao(1L);

        matchByPosicao(jogadoresPorPosicao, Posicao.ATAQUE, 4, "Allejo", "Gomez", "Rivaldo", "Neymar");
        matchByPosicao(jogadoresPorPosicao, Posicao.GOLEIRO, 3, "Alface", "Dida", "DaSilva");
        matchByPosicao(jogadoresPorPosicao, Posicao.DEFESA, 2, "Vincento", "Paco");
    }

    @Test
    void deveAgruparPorPosicaoDefinida(){

        Map<Posicao, List<Jogador>> atacantes = timeService.getJogadoresPorPosicao(1L, Posicao.ATAQUE);

        matchByPosicao(atacantes, Posicao.ATAQUE, 4, "Allejo", "Gomez", "Rivaldo", "Neymar");
    }

    @Test
    void deveRetornarArtilheiro(){
        Jogador jogador = timeService.getArtilheiro(1L);
        Assertions.assertEquals("Allejo", jogador.getNome());
    }

    @Test
    void deveRetornarJogadoresOrdenadosPorGols(){
        List<Jogador> goleadores = timeService.getJogadoresOrdenadosPorGols(1L);

        assertThat(goleadores.stream()
                    .map(Jogador::getNome)
                    .collect(Collectors.toList()),
            contains("Allejo","Neymar","Rivaldo","Dida","Gomez","Vincento","Paco","DaSilva","Alface"));
    }

    private Time mockTime(String nome, List<Jogador> jogadores, Long id) {
        Time time = Mockito.mock(Time.class);

        Mockito.when(time.getNome()).thenReturn(nome);
        Mockito.when(time.getJogadores()).thenReturn(jogadores);
        Mockito.when(time.getId()).thenReturn(id);

        return time;
    }

    private Jogador mock(String nome, int gols, Posicao posicao) {

        Jogador jogador = Mockito.mock(Jogador.class);

        Mockito.when(jogador.getNome()).thenReturn(nome);
        Mockito.when(jogador.getGols()).thenReturn(gols);
        Mockito.when(jogador.getPosicao()).thenReturn(posicao);

        return jogador;
    }

    private void matchByPosicao(final Map<Posicao, List<Jogador>> jogaboresByPosicao, final Posicao posicao, final int quantidadeJogadores, final String... nomes) {

        List<Jogador> jogadores = jogaboresByPosicao.get(posicao);
        assertAll(
                () -> assertThat(jogaboresByPosicao, hasKey(posicao)),
                () -> assertThat(jogaboresByPosicao, hasEntry(posicao, jogadores)),
                () -> assertThat(jogadores, hasSize(quantidadeJogadores)),
                () -> assertThat(jogadores, containsInAnyOrder(matchByNome(nomes)))
        );
    }

    private List<Matcher<Object>> matchByNome(final String... nomes) {

        return Arrays
                .stream(nomes)
                .map(name -> hasProperty("nome", CoreMatchers.is(name)))
                .collect(Collectors.toList());
    }

}

