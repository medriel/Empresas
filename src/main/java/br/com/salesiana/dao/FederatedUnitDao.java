package br.com.salesiana.dao;

import br.com.salesiana.connection.Connection;
import br.com.salesiana.entity.FederatedUnit;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;

public class FederatedUnitDao implements Serializable {
    private final EntityManager entityManager;

    public FederatedUnitDao() {
        this.entityManager = Connection.getEntityManager();
    }

    public void save(FederatedUnit federatedUnit) {
        entityManager.getTransaction().begin();
        entityManager.persist(federatedUnit);
        entityManager.getTransaction().commit();
    }

    public FederatedUnit getByInitials(String initials) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select fu from FederatedUnit fu ");
        jpql.append("where fu.initials = :initials");

        TypedQuery<FederatedUnit> query = entityManager.createQuery(jpql.toString(), FederatedUnit.class);

        query.setParameter("initials", initials);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public FederatedUnit getByName(String name) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select fu from FederatedUnit fu ");
        jpql.append("where fu.name = :name");

        TypedQuery<FederatedUnit> query = entityManager.createQuery(jpql.toString(), FederatedUnit.class);

        query.setParameter("name", name);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
