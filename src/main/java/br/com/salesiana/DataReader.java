package br.com.salesiana;

import br.com.salesiana.utils.FileReader;

import java.util.Scanner;

public class DataReader {
    private final String arquivo;

    public DataReader(String arquivo) {
        this.arquivo = arquivo;
    }

    public void read(Processor processor) {
        read(processor, false);
    }

    public void read(Processor processor, Boolean shouldSkipFirstRow) {
        Scanner statesScanner;
        try {
            statesScanner = FileReader.read(arquivo);
            if (shouldSkipFirstRow) {
                statesScanner.next();
            }
            while (statesScanner.hasNext()) {
                String row = statesScanner.next();
                processor.run(row);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        statesScanner.close();
    }
}
