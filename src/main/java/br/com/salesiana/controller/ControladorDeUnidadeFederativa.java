package br.com.salesiana.controller;

import br.com.salesiana.dao.UnidadeFederativaDao;
import br.com.salesiana.entity.UnidadeFederativa;

public class ControladorDeUnidadeFederativa {

    public UnidadeFederativa create(UnidadeFederativa unidadeFederativa) {
        UnidadeFederativaDao unidadeFederativaDao = new UnidadeFederativaDao();
        UnidadeFederativa existingFederatedUnit = unidadeFederativaDao.getByInitials(unidadeFederativa.getInitials());

        if(existingFederatedUnit == null) {
            unidadeFederativaDao.save(unidadeFederativa);
        }

        return unidadeFederativa;
    }
}
