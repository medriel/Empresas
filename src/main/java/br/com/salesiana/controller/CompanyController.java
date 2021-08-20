package br.com.salesiana.controller;

import br.com.salesiana.dao.CompanyDao;
import br.com.salesiana.entity.Company;

public class CompanyController {
    CompanyDao companyDao = new CompanyDao();

    public Company create(String cnpj, String companyName){
        Company company = companyDao.getCompanyFromCnpj(cnpj);
        if(company == null) {
            company = new Company(cnpj, companyName);
            companyDao.save(company);
        }
        return company;
    }
}
