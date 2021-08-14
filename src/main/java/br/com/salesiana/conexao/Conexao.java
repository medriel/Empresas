package br.com.salesiana.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("empresas");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
