package br.com.salesiana.dao;

import br.com.salesiana.connection.Connection;
import br.com.salesiana.entity.Fiscalization;

import javax.persistence.EntityManager;
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

    public Fiscalization getFiscalizationFromDateAndPostalCodeAndPublicPlace(
            LocalDate date,
            String postalCode,
            String publicPlace
    ) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select f from Fiscalization f ");
        jpql.append("where f.date = :date ");
        jpql.append("and f.postalCode = :postalCode ");
        jpql.append("and f.publicPlace = :publicPlace");

        TypedQuery<Fiscalization> query = entityManager.createQuery(jpql.toString(), Fiscalization.class);

        query.setParameter("date", date);
        query.setParameter("postalCode", postalCode);
        query.setParameter("publicPlace", publicPlace);
        query.setMaxResults(1);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
