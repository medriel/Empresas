package br.com.salesiana.dao;

import br.com.salesiana.connection.Connection;
import br.com.salesiana.entity.District;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;

public class DistrictDao implements Serializable {
    private final EntityManager entityManager;

    public DistrictDao() {
        this.entityManager = Connection.getEntityManager();
    }

    public void save(District district) {
        entityManager.getTransaction().begin();
        entityManager.persist(district);
        entityManager.getTransaction().commit();
    }

    public District getDistrictFromNameAndMunicipality(String name, Long municipalityId) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select d from District d ");
        jpql.append("join d.municipality m ");
        jpql.append("where d.name = :name ");
        jpql.append("and m.id = :municipalityId ");

        TypedQuery<District> query = entityManager.createQuery(jpql.toString(), District.class);

        query.setParameter("name", name);
        query.setParameter("municipalityId", municipalityId);
        query.setMaxResults(1);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}