package br.com.codenation;

import javax.persistence.*;

@Entity
@Table(name = "perguntas_respostas")
public class PerguntaResposta implements Piada{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pergunta;

    private String resposta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPergunta() {

        return pergunta;
    }

    public void setPergunta(String pergunta) {

        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    @Override
    public String contar() {
        return pergunta + "\n" + " Resposta: " + resposta;
    }

    @Override
    public String getTipo() {
        return TiposPiada.PERGUNTARESPOSTA.toString();
    }
}
