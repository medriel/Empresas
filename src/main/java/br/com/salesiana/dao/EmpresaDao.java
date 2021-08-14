package br.com.salesiana.dao;

import br.com.salesiana.conexao.Conexao;
import br.com.salesiana.entity.Empresa;
import br.com.salesiana.entity.Bairro;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;

public class EmpresaDao implements Serializable {

    private final EntityManager entityManager;

    public EmpresaDao() {
        this.entityManager = Conexao.getEntityManager();
    }

    public void save(Empresa empresa) {
        entityManager.getTransaction().begin();
        entityManager.persist(empresa);
        entityManager.getTransaction().commit();
    }

    public Empresa getCompanyFromCnpj(String cnpj) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select c from Empresa c ");
        jpql.append("where c.cnpj = :cnpj");

        TypedQuery<Empresa> query = entityManager.createQuery(jpql.toString(), Empresa.class);

        query.setParameter("cnpj", cnpj);
        query.setMaxResults(1);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
