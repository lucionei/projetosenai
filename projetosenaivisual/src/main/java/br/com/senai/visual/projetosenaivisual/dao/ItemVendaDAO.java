/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.dao;

import br.com.senai.visual.projetosenaivisual.model.ItemVenda;
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
public class ItemVendaDAO {
    
    @PersistenceContext(unitName = "projetosenaivisualPU")
    private EntityManager em;
    
    public void insere(ItemVenda itemVenda) {
        em.persist(itemVenda);
    }
    
    public void excluir(Long id)  {
        em.remove(em.getReference(ItemVenda.class, id));
    }
    
    public ItemVenda buscar(Long id) {
        return em.find(ItemVenda.class, id);
    }
    
    public ItemVenda atualizar(ItemVenda itemVenda) {
        return em.merge(itemVenda);
    }
    
    public List<ItemVenda> lista() {
        TypedQuery q = em.createQuery("select i "+
                "from ItemVenda i order by i.valorItem", ItemVenda.class);
        return q.getResultList();
    }
            
}
