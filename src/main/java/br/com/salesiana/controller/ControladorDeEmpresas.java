package br.com.salesiana.controller;

import br.com.salesiana.entity.*;
import br.com.salesiana.utils.LeitorDeArquivo;

import java.time.LocalDate;
import java.util.Scanner;

public class ControladorDeEmpresas {

    public void readFileAndSplitData() throws Exception {
        Scanner scanner = LeitorDeArquivo.read("Empresas - Santa Catarina.csv");
        scanner.next(); // skips first row

        while(scanner.hasNext()) {
            String[] items = scanner.next().split(";");
            Fiscalizacao fiscalizacao = this.createFiscalization(items);

            System.out.print(fiscalizacao);
        }

        scanner.close();
    }

    private Fiscalizacao createFiscalization(String[] items) throws Exception {
        String  mesEAno = items[1];
        LocalDate data = LocalDate.parse(mesEAno.replace("/", "-") + "-01");
        String cnpj = items[2];
        String razaoSocial = items[3];
        String logradouro = items[4];
        String cep = items[5];
        String nomeBairro = items[6];
        String nomeMunicipio = items[7];
        String nomeUnidadeFederativa = items[8].replaceAll("\\s","");

        String sigla = this.getFederatedUnitInitialsFromName(nomeUnidadeFederativa);
        UnidadeFederativa unidadeFederativa = new UnidadeFederativa(sigla, nomeUnidadeFederativa);
        Municipio municipio = new Municipio(nomeMunicipio, unidadeFederativa);
        Bairro bairro = new Bairro(nomeBairro, municipio);
        Empresa empresa = new Empresa(cnpj, razaoSocial);

        return new Fiscalizacao(
                data,
                logradouro,
                cep,
                empresa,
                bairro,
                municipio,
                unidadeFederativa
        );
    }

    private String getFederatedUnitInitialsFromName(String nomeUnidadeFederativa) throws Exception {
        Scanner scanner = LeitorDeArquivo.read("estados.txt");
        String correctFederatedUnit = "";

        while(scanner.hasNext()) {
            String row = scanner.next();
            String[] items = row.split(",");
            String currentFederatedUnitName = items[0];

            if(currentFederatedUnitName.toLowerCase().replaceAll("\\s","").equals(nomeUnidadeFederativa.toLowerCase())) {
                correctFederatedUnit = items[1].replaceAll("\\s","");
                break;
            }
        }

        return correctFederatedUnit;
    }
}
