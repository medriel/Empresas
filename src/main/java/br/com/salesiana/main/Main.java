package br.com.salesiana.main;

import br.com.salesiana.controller.ControladorDeEmpresas;

public class Main {
    public static void main(String[] args) throws Exception {
        ControladorDeEmpresas controladorDeEmpresas = new ControladorDeEmpresas();
        controladorDeEmpresas.readFileAndSplitData();

        System.exit(0);
    }
}
