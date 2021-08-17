package br.com.salesiana.controller;

import br.com.salesiana.dao.*;
import br.com.salesiana.entity.*;

import java.time.LocalDate;

public class FiscalizationController {
    private FederatedUnitDao federatedUnitDao;
    private MunicipalityDao municipalityDao;
    private DistrictDao districtDao;
    private CompanyDao companyDao;
    private FiscalizationDao fiscalizationDao;


    public FiscalizationController() {
        this.federatedUnitDao = new FederatedUnitDao();
        this.municipalityDao = new MunicipalityDao();
        this.districtDao = new DistrictDao();
        this.companyDao = new CompanyDao();
        this.fiscalizationDao = new FiscalizationDao();
    }

    public Fiscalization createFiscalization(String[] items) throws Exception {
        try {
            String  monthAndYear = items[1];
            LocalDate date = LocalDate.parse(monthAndYear.replace("/", "-") + "-01");
            String cnpj = items[2];
            String companyName = items[3];
            String publicPlace = items[4];
            String postalCode = items[5];
            String districtName = items[6];
            String municipalityName = items[7];
            String federatedUnitName = items[8].trim();

            FederatedUnit federatedUnit = federatedUnitDao.getByName(federatedUnitName);

            Municipality municipality = municipalityDao.getByNameAndFederatedUnit(municipalityName, federatedUnit.getId());
            if(municipality == null) {
                municipality = new Municipality(municipalityName, federatedUnit);
                municipalityDao.save(municipality);
            }

            District district = districtDao.getDistrictFromNameAndMunicipality(districtName, municipality.getId());
            if(district == null) {
                district = new District(districtName, municipality);
                districtDao.save(district);
            }

            Company company = companyDao.getCompanyFromCnpj(cnpj);
            if(company == null) {
                company = new Company(cnpj, companyName);
                companyDao.save(company);
            }

            Fiscalization fiscalization = fiscalizationDao.getFiscalizationFromDateAndPostalCodeAndPublicPlace(date, postalCode, publicPlace);
            if(fiscalization == null) {
                fiscalization = new Fiscalization(
                        date,
                        publicPlace,
                        postalCode,
                        company,
                        district,
                        municipality,
                        federatedUnit
                );
                fiscalizationDao.save(fiscalization);
            }

            return new Fiscalization();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        return null;
    }
}
