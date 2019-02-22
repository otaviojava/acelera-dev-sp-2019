package br.com.codenation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trocadilho implements Piada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trocadilho;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrocadilho() {
        return trocadilho;
    }

    public void setTrocadilho(String trocadilho) {
        this.trocadilho = trocadilho;
    }

    @Override
    public String contar() {
        return this.getTrocadilho();
    }

    @Override
    public String getTipo() {
        return TiposPiada.TROCADILHO.toString();
    }
}
