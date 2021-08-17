package br.com.salesiana.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @ManyToOne
    private Municipality municipality;

    @OneToMany
    private List<Fiscalization> fiscalizations;

    public District() { }


    public void setName(String name) {
        this.name = name;
    }

    public District(String name, Municipality municipality) {
        this.name = name;
        this.municipality = municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", municipality=" + municipality +
                '}';
    }
}
