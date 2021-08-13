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
    private Empresa Empresa;

    @ManyToOne
    private Bairro Bairro;

    @ManyToOne
    private Municipio Municipio;

    @ManyToOne
    private UnidadeFederativa UnidadeFederativa;
}
