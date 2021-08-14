package br.com.salesiana.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("empresas");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
