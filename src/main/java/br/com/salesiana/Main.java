package br.com.salesiana;

public class Main {
    public static void main(String[] args) throws Exception {
        Importer importer = new Importer();
        importer.importFederativeUnits();
        importer.importFiscalizations();
        System.exit(0);
    }
}
