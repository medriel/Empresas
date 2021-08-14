package br.com.salesiana.entity;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    private List<Fiscalizacao> fiscalizacaos;

    public Empresa(){

    }
    public Empresa ( String cnpj, String razaoSocial){
        this.cnpj = cnpj;
        this.razaoSocial=razaoSocial;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setCompanyName(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                '}';
    }
}
