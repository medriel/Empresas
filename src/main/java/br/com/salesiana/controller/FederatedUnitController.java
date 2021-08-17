package br.com.salesiana.controller;

import br.com.salesiana.dao.FederatedUnitDao;
import br.com.salesiana.entity.FederatedUnit;


public class FederatedUnitController {
    public FederatedUnit create(FederatedUnit federatedUnit) {
        FederatedUnitDao federatedUnitDao = new FederatedUnitDao();
        FederatedUnit existingFederatedUnit = federatedUnitDao.getByInitials(federatedUnit.getInitials());

        if(existingFederatedUnit == null) {
            federatedUnitDao.save(federatedUnit);
        }

        return federatedUnit;
    }
}