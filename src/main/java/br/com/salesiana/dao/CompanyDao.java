package br.com.salesiana.dao;

import br.com.salesiana.connection.Connection;
import br.com.salesiana.entity.Company;
import br.com.salesiana.entity.District;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;

public class CompanyDao implements Serializable {
    private final EntityManager entityManager;

    public CompanyDao() {
        this.entityManager = Connection.getEntityManager();
    }

    public void save(Company company) {
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();
    }

    public Company getCompanyFromCnpj(String cnpj) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select c from Company c ");
        jpql.append("where c.cnpj = :cnpj");

        TypedQuery<Company> query = entityManager.createQuery(jpql.toString(), Company.class);

        query.setParameter("cnpj", cnpj);
        query.setMaxResults(1);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
