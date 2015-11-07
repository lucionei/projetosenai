/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.dao;

import br.com.senai.visual.projetosenaivisual.model.Cliente;
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
public class ClienteDAO {

    @PersistenceContext(unitName = "projetosenaivisualPU")
    private EntityManager em;
    
    public void insere(Cliente cliente) {
        em.persist(cliente);
    }
    
    public void excluir(Long id) {
        em.remove(em.getReference(Cliente.class, id));
    }
    
    public Cliente buscar(Long id) {
        return em.find(Cliente.class, id);
    }
    
    public Cliente atualizar(Cliente cliente) {
        return em.merge(cliente);
    }

    public List<Cliente> lista() {
        TypedQuery<Cliente> q = em.createQuery("SELECT c "
                + "FROM Cliente c order by c.nome", Cliente.class);
        return q.getResultList();
    }

}
