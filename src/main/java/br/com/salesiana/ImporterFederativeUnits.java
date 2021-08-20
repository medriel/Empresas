package br.com.salesiana;

import br.com.salesiana.controller.FederatedUnitController;
import br.com.salesiana.entity.FederatedUnit;

public class ImporterFederativeUnits implements Processor{

    private FederatedUnitController federatedUnitController = new FederatedUnitController();

    public ImporterFederativeUnits(){

        DataReader reader = new DataReader("estados.txt");
        reader.read(this);
    }

    public void run(String row){
        String[] items = row.split(",");
        String federatedUnitName = items[0].trim();
        String federatedUnitInitials = items[1].trim();

        federatedUnitController.create(new FederatedUnit(federatedUnitInitials, federatedUnitName));
    }
}
