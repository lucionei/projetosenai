/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.dao;

import br.com.senai.visual.projetosenaivisual.model.Unidade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lucionei
 */
@Stateless
public class UnidadeDAO {

    @PersistenceContext(unitName = "projetosenaivisualPU")
    private EntityManager em;

    public void insere(Unidade unidade) {
        em.persist(unidade);
    }

    public void excluir(Long id) {
        em.remove(em.getReference(Unidade.class, id));
    }

    public Unidade buscar(Long id) {
        return em.find(Unidade.class, id);
    }

    public Unidade atualizar(Unidade unidade) {
        return em.merge(unidade);
    }

    public List<Unidade> lista() {
        TypedQuery<Unidade> q = em.createQuery("SELECT u " +
                "FROM Unidade u order by u.descricaoAbreviada", Unidade.class);
        return q.getResultList();
    }

}
