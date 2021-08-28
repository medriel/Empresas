package br.com.salesiana.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cnpj", length = 18, nullable = false, unique = true)
    private String cnpj;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @OneToMany
    private List<Fiscalization> fiscalizations;

    public Company() {
    }

    public Company(String cnpj, String companyName) {
        this.cnpj = cnpj;
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Fiscalization> getFiscalizations() {
        return fiscalizations;
    }

    public void setFiscalizations(List<Fiscalization> fiscalizations) {
        this.fiscalizations = fiscalizations;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
