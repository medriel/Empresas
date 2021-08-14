package br.com.salesiana.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Fiscalizacao")

public class Fiscalizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "cep")
    private String cep;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private Bairro bairro;

    @ManyToOne
    private Municipio municipio;

    @ManyToOne
    private UnidadeFederativa unidadeFederativa;

    public Fiscalizacao(){

    }

    public Fiscalizacao(
            LocalDate data,
            String logradouro,
            String cep,
            Empresa empresa,
            Bairro bairro,
            Municipio municipio,
            UnidadeFederativa unidadeFederativa
    ) {
        this.data = data;
        this.logradouro = logradouro;
        this.cep = cep;
        this.empresa = empresa;
        this.bairro = bairro;
        this.municipio = municipio;
        this.unidadeFederativa = unidadeFederativa;
    }

    public void setDate(LocalDate data) {
        this.data = data;
    }

    public void setPublicPlace(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setPostalCode(String cep) {
        this.cep = cep;
    }

    public void setCompany(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setDistrict(Bairro bairro) {
        this.bairro = bairro;
    }

    public void setMunicipality(Municipio municipio) {
        this.municipio = municipio;
    }

    public void setFederatedUnit(UnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    @Override
    public String toString() {
        return "Fiscalizacao{" +
                "id=" + id +
                ", data=" + data +
                ", logradouro='" + logradouro + '\'' +
                ", cep='" + cep + '\'' +
                ", empresa=" + empresa +
                ", bairro=" + bairro +
                ", municipio=" + municipio +
                ", unidadeFederativa=" + unidadeFederativa +
                '}';
    }
}
