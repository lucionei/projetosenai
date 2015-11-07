/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.rest;

import br.com.senai.visual.projetosenaivisual.dao.UnidadeDAO;
import br.com.senai.visual.projetosenaivisual.model.Unidade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Lucionei
 */
@Stateless
@Path("unidade")
@Produces(MediaType.APPLICATION_JSON)
public class UnidadeResource {
    
    @Inject
    private UnidadeDAO unidadeDAO;
    
    @GET
    public List<Unidade> list(){
        return unidadeDAO.lista();
    }
    
}
