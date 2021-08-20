package br.com.salesiana;

import br.com.salesiana.controller.*;
import br.com.salesiana.entity.*;

import java.time.LocalDate;

public class ImporterFiscalization implements Processor{

    FederatedUnitController federatedUnitController = new FederatedUnitController();
    MunicipalityController municipalityController = new MunicipalityController();
    DistrictController districtController = new DistrictController();
    CompanyController companyController = new CompanyController();
    FiscalizationController fiscalizationController = new FiscalizationController();

    public void importFiscalizations() throws Exception {
        DataReader reader = new DataReader("Empresas - Santa Catarina.csv");
        reader.read(this);
    }

    @Override
    public void run(String row) throws Exception {
        String[] arrayItems = row.split(";");
        String  monthAndYear = arrayItems[1];
        LocalDate date = LocalDate.parse(monthAndYear.replace("/", "-") + "-01");
        String cnpj = arrayItems[2];
        String companyName = arrayItems[3];
        String publicPlace = arrayItems[4];
        String postalCode = arrayItems[5];
        String districtName = arrayItems[6];
        String municipalityName = arrayItems[7];
        String federatedUnitName = arrayItems[8].trim();

        FederatedUnit federatedUnit = federatedUnitController.getByName(federatedUnitName);

        Municipality municipality =  municipalityController.create(municipalityName, federatedUnit.getId());

        District district =  districtController.create(districtName,municipality);

        Company company = companyController.create(cnpj,companyName);

        Fiscalization fiscalization = fiscalizationController.create(
                date,
                publicPlace,
                postalCode,
                company,
                district,
                municipality,
                federatedUnit);

    }
}
