package br.com.salesiana.controller;

import br.com.salesiana.dao.FederatedUnitDao;
import br.com.salesiana.entity.FederatedUnit;


public class FederatedUnitController {
    FederatedUnitDao federatedUnitDao = new FederatedUnitDao();

    public FederatedUnit create(FederatedUnit federatedUnit) {
        FederatedUnit existingFederatedUnit = federatedUnitDao.getByInitials(federatedUnit.getInitials());

        if(existingFederatedUnit == null) {
            federatedUnitDao.save(federatedUnit);
        }

        return federatedUnit;
    }

    public FederatedUnit getByName(String name) {
        return federatedUnitDao.getByName(name);
    }
}