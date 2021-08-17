package br.com.salesiana.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "municipality")
public class Municipality implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @ManyToOne
    private FederatedUnit federatedUnit;

    @OneToMany
    private List<District> districts;

    @OneToMany
    private List<Fiscalization> fiscalizations;

    public Municipality() { }

    public Municipality(String name, FederatedUnit federatedUnit) {
        this.name = name;
        this.federatedUnit = federatedUnit;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFederatedUnit(FederatedUnit federatedUnit) {
        this.federatedUnit = federatedUnit;
    }

    @Override
    public String toString() {
        return "Municipality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", federatedUnit=" + federatedUnit +
                '}';
    }
}
