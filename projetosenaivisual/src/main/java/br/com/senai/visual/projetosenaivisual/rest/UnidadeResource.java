/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.rest;

import br.com.senai.visual.projetosenaivisual.dao.ClienteDAO;
import br.com.senai.visual.projetosenaivisual.dao.UnidadeDAO;
import br.com.senai.visual.projetosenaivisual.model.Cliente;
import br.com.senai.visual.projetosenaivisual.model.Unidade;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Unidade insert(Unidade unidade) {
        unidadeDAO.insere(unidade);     
        return unidade;
    }
    
    @GET
    public List<Unidade> list(){
        return unidadeDAO.lista();
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        unidadeDAO.excluir(id);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Unidade update(@PathParam("id") Long id, Unidade unidade) {
        if (!Objects.equals(id, unidade.getId())) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return unidadeDAO.atualizar(unidade);
    }
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id) {
        final Unidade unidade = unidadeDAO.buscar(id);
        if (unidade == null) {
            throw new EntityNotFoundException();
        }
        return Response.ok(unidade).build();
    }
    
}
