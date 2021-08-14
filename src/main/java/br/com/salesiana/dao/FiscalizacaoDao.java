package br.com.salesiana.dao;

import br.com.salesiana.conexao.Conexao;
import br.com.salesiana.entity.Fiscalizacao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;

public class FiscalizacaoDao {
    private final EntityManager entityManager;

    public FiscalizacaoDao() {
        this.entityManager = Conexao.getEntityManager();
    }

    public void save(Fiscalizacao fiscalizacao) {
        entityManager.getTransaction().begin();
        entityManager.persist(fiscalizacao);
        entityManager.getTransaction().commit();
    }

    public Fiscalizacao getFiscalizationFromDateAndPostalCodeAndPublicPlace(
            LocalDate data,
            String cep,
            String logradouro
    ) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select f from Fiscalizacao f ");
        jpql.append("where f.date = :data ");
        jpql.append("and f.cep = :cep ");
        jpql.append("and f.logradouro = :logradouro");

        TypedQuery<Fiscalizacao> query = entityManager.createQuery(jpql.toString(), Fiscalizacao.class);

        query.setParameter("data", data);
        query.setParameter("cep", cep);
        query.setParameter("logradouro", logradouro);
        query.setMaxResults(1);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
