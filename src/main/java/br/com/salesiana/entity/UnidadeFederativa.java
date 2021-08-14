package br.com.salesiana.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UnidadeFederativa")

public class UnidadeFederativa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sigla")
    private String sigla;

    @Column(name = "nome")
    private String nome;

    public UnidadeFederativa(
            String sigla,
            String nome
    ) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public void setInitials(String sigla) {
        this.sigla = sigla;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public String getInitials() {
        return sigla;
    }

    public String getName() {
        return nome;
    }

    @Override
    public String toString() {
        return "UnidadeFederativa{" +
                "id=" + id +
                ", nome=" + nome +
                ", sigla=" + sigla +
                "}";
    }
}
