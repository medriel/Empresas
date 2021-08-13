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
    private Municipio Municipio;
}
