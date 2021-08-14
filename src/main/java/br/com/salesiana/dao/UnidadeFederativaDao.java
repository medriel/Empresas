package br.com.salesiana.dao;

import br.com.salesiana.conexao.Conexao;
import br.com.salesiana.entity.UnidadeFederativa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UnidadeFederativaDao {

    private final EntityManager entityManager;

    public UnidadeFederativaDao(){
        this.entityManager = Conexao.getEntityManager();
    }


    public void save(UnidadeFederativa unidadeFederativa) {
        entityManager.getTransaction().begin();
        entityManager.persist(unidadeFederativa);
        entityManager.getTransaction().commit();
    }

    public UnidadeFederativa getByInitials(String sigla) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select fu from UnidadeFederativa fu ");
        jpql.append("where fu.sigla = :sigla");

        TypedQuery<UnidadeFederativa> query = entityManager.createQuery(jpql.toString(), UnidadeFederativa.class);

        query.setParameter("sigla", sigla);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public UnidadeFederativa getByName(String nome) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select fu from UnidadeFederativa fu ");
        jpql.append("where fu.nome = :nome");

        TypedQuery<UnidadeFederativa> query = entityManager.createQuery(jpql.toString(), UnidadeFederativa.class);

        query.setParameter("nome", nome);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
