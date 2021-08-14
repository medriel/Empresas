package br.com.salesiana.entity;

import javax.persistence.*;

@Entity
@Table(name = "Bairro")

public class Bairro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToOne
    private Municipio municipio;

    public void setName(String nome) {
        this.nome = nome;
    }

    public Bairro(String nome, Municipio municipio) {
        this.nome = nome;
        this.municipio = municipio;
    }

    public void setMunicipality(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", municipio=" + municipio +
                '}';
    }
}
