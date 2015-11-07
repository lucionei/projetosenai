/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.dao;

import br.com.senai.visual.projetosenaivisual.model.Unidade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jean_pandini
 * @param <T>
 */
public abstract class AbstractDAO<T> implements Serializable {
    
    private final Class<T> entityClass;
    
    @PersistenceContext(unitName = "projetosenaivisualPU")
    private EntityManager em;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public void insere(T obj) {
        em.persist(obj);
    }

    public void excluir(T unidade) {
        em.remove(unidade);
    }

    public T buscar(Long id) {
        return em.find(this.entityClass, id);
    }

    public T atualizar(T objDAO) {
        return em.merge(objDAO);
    }

    public List<?> lista() {
        TypedQuery<?> q = em.createQuery("SELECT u " +
                "FROM Unidade u order by u.descricaoAbreviada", this.entityClass);
        return q.getResultList();
    }
}
