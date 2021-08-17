package br.com.salesiana.dao;

import br.com.salesiana.connection.Connection;
import br.com.salesiana.entity.FederatedUnit;
import br.com.salesiana.entity.Municipality;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;

public class MunicipalityDao implements Serializable {
    private final EntityManager entityManager;

    public MunicipalityDao() {
        this.entityManager = Connection.getEntityManager();
    }

    public void save(Municipality municipality) {
        entityManager.getTransaction().begin();
        entityManager.persist(municipality);
        entityManager.getTransaction().commit();
    }

    public Municipality getByNameAndFederatedUnit(String name, Long federatedUnitId) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select m from Municipality m ");
        jpql.append("join m.federatedUnit f ");
        jpql.append("where m.name = :name ");
        jpql.append("and f.id = :federatedUnitId");

        TypedQuery<Municipality> query = entityManager.createQuery(jpql.toString(), Municipality.class);

        query.setParameter("name", name);
        query.setParameter("federatedUnitId", federatedUnitId);
        query.setMaxResults(1);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
