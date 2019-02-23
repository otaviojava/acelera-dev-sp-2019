package org.acelera.saopaulo.soccer.webapi;

import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.acelera.saopaulo.soccer.domain.Jogador;
import org.acelera.saopaulo.soccer.domain.Posicao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.acelera.saopaulo.soccer.domain.Posicao.ATAQUE;
import static org.acelera.saopaulo.soccer.domain.Posicao.DEFESA;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TimeController.class)
class TestTimeController
{
    private static final String BASE_URI = "/times";
    private static final String JOGADORES_PATH = "jogadores";

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc requestHandler;

    @BeforeEach
    void setUp() throws Exception
    {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        adicionarJogador("Bobo", 3, DEFESA);
        adicionarJogador("Lima", 5, ATAQUE);
        adicionarJogador("Neymar", 1, ATAQUE);
    }

    @Test
    @DisplayName("Deve listar os jogadores com direito ao gol no fantástico")
    void deveRetornarFantastico() throws Exception
    {
        executarRequisicao(get(getEndpoint("fantasticos")), status().isOk());
    }

    @Test
    @DisplayName("Deve agrupar os jogadores pela posição")
    void deveAgruparPorPosicao() throws Exception
    {
        executarRequisicao(get(getEndpoint("posicoes")), status().isOk());
    }

    @Test
    @DisplayName("Deve retornar o artilheiro do time")
    void deveRetornarArtilheiro() throws Exception
    {
        executarRequisicao(get(getEndpoint("artilheiros")), status().isOk());
    }

    @Test
    @DisplayName("Deve ordenar os jogadores pelo número de gols")
    void deveRetornarOrdenadoPorGols() throws Exception
    {
        executarRequisicao(get(getEndpoint("ordenados")), status().isOk());
    }

    private void executarRequisicao(MockHttpServletRequestBuilder requestBuilder, ResultMatcher status) throws Exception
    {
        requestHandler.perform(requestBuilder
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status)
                .andExpect(jsonPath("$", notNullValue()));
    }

    private void adicionarJogador(String nome, int gols, Posicao posicao) throws Exception
    {
        Jogador jogador = Jogador.builder()
                .withNome(nome)
                .withGols(gols)
                .withPosicao(posicao)
                .build();

        byte[] bytes = mapper.writeValueAsBytes(jogador);

        executarRequisicao(post(getEndpoint(null)).content(bytes), status().isCreated());
    }

    private String getEndpoint(String parametro)
    {
        StringJoiner joiner = new StringJoiner("/").add(BASE_URI).add(JOGADORES_PATH);

        if (parametro != null)
        {
            joiner.add(parametro);
        }
        return joiner.toString();
    }

}