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

    public Fiscalization create(LocalDate date,
                                String publicPlace,
                                String postalCode,
                                Company company,
                                District district,
                                Municipality municipality,
                                FederatedUnit federatedUnit) throws Exception {
        try {





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
