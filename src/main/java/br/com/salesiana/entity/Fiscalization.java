package br.com.salesiana.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fiscalization")
public class Fiscalization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "public_place", length = 100, nullable = false)
    private String publicPlace;

    @Column(name = "postal_code", length = 20, nullable = false)
    private String postalCode;

    @ManyToOne
    private Company company;

    @ManyToOne
    private District district;

    @ManyToOne
    private Municipality municipality;

    @ManyToOne
    private FederatedUnit federatedUnit;

    public Fiscalization() { }

    public Fiscalization(
            LocalDate date,
            String publicPlace,
            String postalCode,
            Company company,
            District district,
            Municipality municipality,
            FederatedUnit federatedUnit
    ) {
        this.date = date;
        this.publicPlace = publicPlace;
        this.postalCode = postalCode;
        this.company = company;
        this.district = district;
        this.municipality = municipality;
        this.federatedUnit = federatedUnit;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public void setFederatedUnit(FederatedUnit federatedUnit) {
        this.federatedUnit = federatedUnit;
    }

    @Override
    public String toString() {
        return "Fiscalization{" +
                "id=" + id +
                ", date=" + date +
                ", publicPlace='" + publicPlace + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", company=" + company +
                ", district=" + district +
                ", municipality=" + municipality +
                ", federatedUnit=" + federatedUnit +
                '}';
    }
}
