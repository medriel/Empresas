package br.com.salesiana;

import br.com.salesiana.controller.ControladorDeUnidadeFederativa;
import br.com.salesiana.controller.ControladorDeEmpresas;
import br.com.salesiana.entity.UnidadeFederativa;
import br.com.salesiana.utils.LeitorDeArquivo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        LeitorDeArquivo leitorDeArquivo = new LeitorDeArquivo();
        Scanner statesScanner = leitorDeArquivo.read("estados.txt");

        while(statesScanner.hasNext()) {
            String row = statesScanner.next();
            String[] items = row.split(",");
            String id_uf = items[0].trim();
            String sigla = items[1].trim();

            ControladorDeUnidadeFederativa controladorDeUnidadeFederativa = new ControladorDeUnidadeFederativa();
            controladorDeUnidadeFederativa.create(new UnidadeFederativa(sigla, id_uf));
        }

        statesScanner.close();

        Scanner fiscalizationScanner = leitorDeArquivo.read("Empresas - Santa Catarina.csv");
        fiscalizationScanner.next(); // skips first row

        while(fiscalizationScanner.hasNext()) {
            String[] items = fiscalizationScanner.next().split(";");

            ControladorDeEmpresas controladorDeEmpresas = new ControladorDeEmpresas();
            controladorDeEmpresas.createFiscalization(items);
        }

        fiscalizationScanner.close();

        System.exit(0);
    }
}
