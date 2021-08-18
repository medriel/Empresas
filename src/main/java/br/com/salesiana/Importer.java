package br.com.salesiana;

import br.com.salesiana.controller.FederatedUnitController;
import br.com.salesiana.controller.FiscalizationController;
import br.com.salesiana.entity.FederatedUnit;
import br.com.salesiana.utils.FileReader;

import java.util.Scanner;

public class Importer {

    public void importFederativeUnits() throws Exception{
        FileReader fileReader = new FileReader();
        Scanner statesScanner = fileReader.read("estados.txt");

        while(statesScanner.hasNext()) {
            String row = statesScanner.next();
            String[] items = row.split(",");
            String federatedUnitName = items[0].trim();
            String federatedUnitInitials = items[1].trim();

            FederatedUnitController federatedUnitController = new FederatedUnitController();
            federatedUnitController.create(new FederatedUnit(federatedUnitInitials, federatedUnitName));
        }

        statesScanner.close();
    }
    public void importFiscalizations() throws Exception{
        FileReader fileReader = new FileReader();
        Scanner fiscalizationScanner = fileReader.read("Empresas - Santa Catarina.csv");
        fiscalizationScanner.next();

        while(fiscalizationScanner.hasNext()) {
            String[] items = fiscalizationScanner.next().split(";");

            FiscalizationController fiscalizationController = new FiscalizationController();
            fiscalizationController.createFiscalization(items);
        }

        fiscalizationScanner.close();
    }
}
