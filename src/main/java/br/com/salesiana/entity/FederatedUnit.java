package br.com.salesiana.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "federated_unit")
public class FederatedUnit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "initials", length = 2, nullable = false, unique = true)
    private String initials;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @OneToMany
    private List<Municipality> municipalities;

    @OneToMany
    private List<Fiscalization> fiscalizations;

    public FederatedUnit() { }

    public FederatedUnit(
            String initials,
            String name
    ) {
        this.initials = initials;
        this.name = name;
    }


    public void setInitials(String initials) {
        this.initials = initials;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getInitials() {
        return initials;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FederatedUnit{" +
                "id=" + id +
                ", name=" + name +
                ", initials=" + initials +
                "}";
    }
}
