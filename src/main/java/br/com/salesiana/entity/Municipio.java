package br.com.salesiana.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Municipio")

public class Municipio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_uf")
    private UnidadeFederativa unidadeFederativa;

    @OneToMany
    private List<Bairro> bairros;

    @OneToMany
    private List<Fiscalizacao> fiscalizacoes;

    public Municipio() {

    }

    public Municipio(String nome, UnidadeFederativa unidadeFederativa) {
        this.nome = nome;
        this.unidadeFederativa = unidadeFederativa;
    }

    public Long getId() {
        return id;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public void setFederatedUnit(UnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", unidadeFederativa=" + unidadeFederativa +
                '}';
    }
}
