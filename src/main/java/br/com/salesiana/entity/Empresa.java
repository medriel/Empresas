package br.com.salesiana.entity;

import javax.persistence.*;

@Entity
@Table(name = "Empresa")

public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "cnpj", length = 14, nullable = false)
    private String cnpj;

    @Column(name = "razaoSocial", length = 100, nullable = false)
    private String razaoSocial;
}
