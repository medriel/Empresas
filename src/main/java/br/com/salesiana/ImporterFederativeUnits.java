package br.com.salesiana;

import br.com.salesiana.controller.FederatedUnitController;
import br.com.salesiana.controller.FiscalizationController;
import br.com.salesiana.entity.FederatedUnit;

public class Importer implements Processor{

    private FederatedUnitController federatedUnitController = new FederatedUnitController();
    private FiscalizationController fiscalizationController = new FiscalizationController();

    public void importFederativeUnits() throws Exception{

        DataReader reader = new DataReader("estados.txt");
        reader.read(this);
    }

    public void run(String row){
        String[] items = row.split(",");
        String federatedUnitName = items[0].trim();
        String federatedUnitInitials = items[1].trim();

        federatedUnitController.create(new FederatedUnit(federatedUnitInitials, federatedUnitName));
    }

//    public void importFiscalizations() throws Exception{
//        Scanner fiscalizationScanner = FileReader.read("Empresas - Santa Catarina.csv");
//        fiscalizationScanner.next();
//
//        while(fiscalizationScanner.hasNext()) {
//            String[] items = fiscalizationScanner.next().split(";");
//
//            fiscalizationController.createFiscalization(items);
//        }
//
//        fiscalizationScanner.close();
//    }
}
