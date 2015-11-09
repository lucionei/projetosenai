/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.dao;

import br.com.senai.visual.projetosenaivisual.model.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author lucionei.chequeto
 */
@Stateless
public class ProdutoDAO {

    @PersistenceContext(unitName = "projetosenaivisualPU")
    private EntityManager em;

    public void insere(Produto produto) {
        em.persist(produto);
    }

    public void excluir(Long id) {
        em.remove(em.getReference(Produto.class, id));
    }

    public Produto buscar(Long id) {
        return em.find(Produto.class, id);
    }

    public Produto atualizar(Produto produto) {
        return em.merge(produto);
    }

    public List<Produto> lista() {
        TypedQuery<Produto> q = em.createQuery("SELECT p " +
                "FROM Produto p order by p.descricao", Produto.class);
        return q.getResultList();
    }
}
