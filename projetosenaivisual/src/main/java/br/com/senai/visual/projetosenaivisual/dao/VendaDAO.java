/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.dao;

import br.com.senai.visual.projetosenaivisual.model.Venda;
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
public class VendaDAO {

    @PersistenceContext(unitName = "projetosenaivisualPU")
    private EntityManager em;

    public void insere(Venda venda) {
        em.persist(venda);
    }

    public void excluir(Long id) {
        em.remove(em.getReference(Venda.class, id));
    }

    public Venda buscar(Long id) {
        return em.find(Venda.class, id);
    }

    public void atualizar(Venda venda) {
        em.merge(venda);
    }

    public List<Venda> lista() {
        TypedQuery<Venda> q = em.createQuery("SELECT v "
                + "FROM Venda v order by v.dataEmissao", Venda.class);
        return q.getResultList();
    }

}
