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
}
