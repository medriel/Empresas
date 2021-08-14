package br.com.salesiana.controller;
import java.io.File;
import java.util.Scanner;

public class LeitorDeArquivo {
    public void read(String fileName) throws Exception {
        String path = System.getProperty("user.dir") + "/";

        Scanner scanner = new Scanner(new File(path + "/" + fileName));
        scanner.useDelimiter("\n");
        scanner.next();

        while(scanner.hasNext()) {
            String[] items = scanner.next().split(";");

            for(String item: items) {
                System.out.println(item);
            }
        }
        scanner.close();
    }
}
