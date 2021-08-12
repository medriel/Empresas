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
    private FederatedUnit id_uf;

    @OneToMany(mappedBy = "Municipio")
    private List<District> Municipio = new ArrayList<District>();
}
