package br.com.salesiana.dao;

import br.com.salesiana.connection.Connection;
import br.com.salesiana.entity.Company;
import br.com.salesiana.entity.Fiscalization;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.time.LocalDate;

public class FiscalizationDao {
    private final EntityManager entityManager;

    public FiscalizationDao() {
        this.entityManager = Connection.getEntityManager();
    }

    public void save(Fiscalization fiscalization) {
        entityManager.getTransaction().begin();
        entityManager.persist(fiscalization);
        entityManager.getTransaction().commit();
    }

    public Fiscalization findByFromDateAndPostalCodeAndPublicPlace(
            LocalDate date,
            Company company
    ) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select f from Fiscalization f ");
        jpql.append("join f.company c ");
        jpql.append("where f.date = :date ");
        jpql.append("and c.id = :companyId");

        TypedQuery<Fiscalization> query = entityManager.createQuery(jpql.toString(), Fiscalization.class);

        query.setParameter("date", date);
        query.setParameter("companyId", company.getId());

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
