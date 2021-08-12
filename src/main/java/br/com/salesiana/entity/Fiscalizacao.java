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

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Company id_empresa;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "cep")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "id_bairro")
    private District id_bairro;

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipality id_municipio;

    @ManyToOne
    @JoinColumn(name = "id_uf")
    private FederatedUnit id_uf;
}
