package br.com.salesiana.utils;

import java.time.LocalDate;

public class FiscalizationCSV {

    private String monthAndYear;
    private LocalDate date;
    private String cnpj;
    private String companyName;
    private String publicPlace;
    private String postalCode;
    private String districtName;
    private String municipalityName;
    private String federatedUnitName;

    public FiscalizationCSV(String row) {

        String[] arrayItems = row.split(";");
        monthAndYear = arrayItems[1];
        date = LocalDate.parse(monthAndYear.replace("/", "-") + "-01");
        cnpj = arrayItems[2];
        companyName = arrayItems[3];
        publicPlace = arrayItems[4];
        postalCode = arrayItems[5];
        districtName = arrayItems[6];
        municipalityName = arrayItems[7];
        federatedUnitName = arrayItems[8].trim();
    }

    public String getMonthAndYear() {
        return monthAndYear;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public String getFederatedUnitName() {
        return federatedUnitName;
    }
}

