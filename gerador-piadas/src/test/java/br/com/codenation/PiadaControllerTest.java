package br.com.codenation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PiadasController.class)
public class PiadaControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PiadasService service;

    @Test
    public void getPerguntasRespostas() throws Exception {
        PerguntaResposta pr = new PerguntaResposta();
        pr.setId(1L);
        pr.setPergunta("Qual o cachorro bom de briga ?");
        pr.setResposta("É o Jiu shitzu");

        given(service.getPerguntasRespostasRandom()).willReturn(pr);

        mvc.perform(get("/piadas/perguntas-respostas")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()));
    }

    @Test
    public void getPerguntasRespostasNull() throws Exception {

        given(service.getPerguntasRespostasRandom()).willThrow(NullPointerException.class);

        mvc.perform(get("/piadas/perguntas-respostas")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void getTrocadilho() throws Exception {
        Trocadilho utc = new Trocadilho();
        utc.setId(1L);
        utc.setTrocadilho("Antes tarde Duke Nukem");

        given(service.getTrocadilhoRandom()).willReturn(utc);

        mvc.perform(get("/piadas/trocadilhos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()));
    }

    @Test
    public void getTrocadilhosNull() throws Exception {

        given(service.getTrocadilhoRandom()).willThrow(NullPointerException.class);

        mvc.perform(get("/piadas/trocadilhos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }
}
