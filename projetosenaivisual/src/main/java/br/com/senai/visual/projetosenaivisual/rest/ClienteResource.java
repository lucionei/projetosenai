/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.rest;

import br.com.senai.visual.projetosenaivisual.dao.ClienteDAO;
import br.com.senai.visual.projetosenaivisual.model.Cliente;
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
@Path("cliente")
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {
    
    @Inject
    private ClienteDAO clienteDAO;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Cliente insert(Cliente cliente) {
        clienteDAO.insere(cliente);
        return cliente;
    }
    
    @GET
    public List<Cliente> list() {
        return clienteDAO.lista();
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        clienteDAO.excluir(id);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Cliente update(@PathParam("id") Long id, Cliente cliente) {
        if (!Objects.equals(id, cliente.getId())) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return clienteDAO.atualizar(cliente);
    }
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id) {
        final Cliente cliente = clienteDAO.buscar(id);
        if (cliente == null) {
            throw new EntityNotFoundException();
        }
        return Response.ok(cliente).build();
    }
    
}
