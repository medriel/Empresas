package br.com.salesiana.dao;

import br.com.salesiana.conexao.Conexao;
import br.com.salesiana.entity.Bairro;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;

public class BairroDao implements Serializable{

    private final EntityManager entityManager;

    public BairroDao() {
        this.entityManager = Conexao.getEntityManager();
    }

    public void save(Bairro bairro) {
        entityManager.getTransaction().begin();
        entityManager.persist(bairro);
        entityManager.getTransaction().commit();
    }

    public Bairro getDistrictFromNameAndMunicipality(String nome, Long id_municipio) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select d from Bairro d ");
        jpql.append("join d.municipio m ");
        jpql.append("where d.nome = :nome ");
        jpql.append("and m.id = :id_municipio ");

        TypedQuery<Bairro> query = entityManager.createQuery(jpql.toString(), Bairro.class);

        query.setParameter("nome", nome);
        query.setParameter("id_municipio", id_municipio);
        query.setMaxResults(1);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
