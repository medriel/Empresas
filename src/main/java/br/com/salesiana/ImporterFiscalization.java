package br.com.salesiana;

import br.com.salesiana.controller.*;
import br.com.salesiana.entity.*;
import br.com.salesiana.utils.FiscalizationCSV;

public class ImporterFiscalization implements Processor {

    private FederatedUnitController federatedUnitController = new FederatedUnitController();
    private MunicipalityController municipalityController = new MunicipalityController();
    private DistrictController districtController = new DistrictController();
    private CompanyController companyController = new CompanyController();
    private FiscalizationController fiscalizationController = new FiscalizationController();

    public void importFiscalizations(){
        DataReader reader = new DataReader("Empresas - Santa Catarina.csv");
        reader.read(this);
    }

    @Override
    public void run(String row){

        FiscalizationCSV csv = new FiscalizationCSV(row);

        FederatedUnit federatedUnit = federatedUnitController.getByName(csv.getFederatedUnitName());
        Municipality municipality = municipalityController.create(csv.getMunicipalityName(), federatedUnit.getId());
        District district = districtController.create(csv.getDistrictName(), municipality);
        Company company = companyController.create(csv.getCnpj(), csv.getCompanyName());

        Fiscalization fiscalizationParam = new Fiscalization();
        fiscalizationParam.setCompany(company);
        fiscalizationParam.setDate(csv.getDate());
        fiscalizationParam.setPublicPlace(csv.getPublicPlace());

        fiscalizationParam.setFederatedUnit(federatedUnit);

        Fiscalization fiscalization = fiscalizationController.create(fiscalizationParam);

    }
}
