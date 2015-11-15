/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.rest;

import br.com.senai.visual.projetosenaivisual.dao.ItemVendaDAO;
import br.com.senai.visual.projetosenaivisual.model.ItemVenda;
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
@Path("itemvenda")
@Produces(MediaType.APPLICATION_JSON)
public class ItemVendaResource {
    
    @Inject
    private ItemVendaDAO itemVendaDAO;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ItemVenda insert(ItemVenda itemVenda) {
        itemVendaDAO.insere(itemVenda);
        return itemVenda;
    }
    
    @GET
    public List<ItemVenda> list() {
        return itemVendaDAO.lista();
    }
    
    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id") Long id) {
        itemVendaDAO.excluir(id);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ItemVenda update(@PathParam("id") Long id, ItemVenda itemVenda) {
        if (!Objects.equals(id, itemVenda.getId())) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return itemVendaDAO.atualizar(itemVenda);
    }
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id) {
        final ItemVenda itemVenda = itemVendaDAO.buscar(id);
        if (itemVenda == null) {
            throw new EntityNotFoundException();
        }
        return Response.ok(itemVenda).build();
    }    
    
}
