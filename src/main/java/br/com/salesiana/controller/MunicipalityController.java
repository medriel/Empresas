package br.com.salesiana.controller;

import br.com.salesiana.dao.MunicipalityDao;
import br.com.salesiana.entity.Municipality;

public class MunicipalityController {

    private MunicipalityDao municipalityDao = new MunicipalityDao();

    public Municipality create(String name, Long federatedUnitId) {
        Municipality existingMunicipality = municipalityDao.getByNameAndFederatedUnit(name, federatedUnitId);
        if (existingMunicipality == null) {
            municipalityDao.save(existingMunicipality);
        }
        return existingMunicipality;
    }
}
