package br.com.salesiana.controller;

import br.com.salesiana.dao.*;
import br.com.salesiana.entity.*;

public class FiscalizationController {

    private FiscalizationDao fiscalizationDao;

    public FiscalizationController() {
        this.fiscalizationDao = new FiscalizationDao();
    }

    public Fiscalization create(Fiscalization fiscalizationParam) {
        try {
            Fiscalization fiscalization = fiscalizationDao.findByFromDateAndCompany(fiscalizationParam.getDate(), fiscalizationParam.getCompany());
            if (fiscalization == null) {
                fiscalizationDao.save(fiscalizationParam);
                return fiscalizationParam;
            }
            return fiscalization;
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return null;
    }
}
