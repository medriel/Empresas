package br.com.salesiana.dao;

import br.com.salesiana.conexao.Conexao;
import br.com.salesiana.entity.UnidadeFederativa;
import br.com.salesiana.entity.Municipio;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;

public class MunicipioDao implements Serializable{

    private final EntityManager entityManager;

    public MunicipioDao() {
        this.entityManager = Conexao.getEntityManager();
    }

    public void save(Municipio municipio) {
        entityManager.getTransaction().begin();
        entityManager.persist(municipio);
        entityManager.getTransaction().commit();
    }

    public Municipio getByNameAndFederatedUnit(String nome, Long id_uf) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select m from Municipio m ");
        jpql.append("join m.unidadeFederativa f ");
        jpql.append("where m.nome = :nome ");
        jpql.append("and f.id = :id_uf");

        TypedQuery<Municipio> query = entityManager.createQuery(jpql.toString(), Municipio.class);

        query.setParameter("nome", nome);
        query.setParameter("id_uf", id_uf);
        query.setMaxResults(1);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
