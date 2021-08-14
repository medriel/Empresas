package br.com.salesiana.main;

import br.com.salesiana.controller.LeitorDeArquivo;

public class Main {
    public static void main(String[] args) throws Exception{

        LeitorDeArquivo leitorDeArquivo = new LeitorDeArquivo();
        leitorDeArquivo.read("Empresas - Santa Catarina.csv");
        System.exit(0);
        System.exit(0);
    }
}
