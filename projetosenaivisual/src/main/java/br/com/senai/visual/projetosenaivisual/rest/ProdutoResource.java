/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.rest;

import br.com.senai.visual.projetosenaivisual.dao.ProdutoDAO;
import br.com.senai.visual.projetosenaivisual.model.Produto;
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
 * @author lucionei.chequeto
 */
@Stateless
@Path("produto")
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    private ProdutoDAO produtoDAO;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Produto insert(Produto produto) {
        produtoDAO.insere(produto);
        return produto;
    }
    
    @GET
    public List<Produto> list() {
        return produtoDAO.lista();
    }
    
    @DELETE 
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        produtoDAO.excluir(id);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Produto update(@PathParam("id") Long id, Produto produto) {
        if (!Objects.equals(id, produto.getId())){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return produtoDAO.atualizar(produto);
    }
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id) {
        final Produto produto = produtoDAO.buscar(id);
        if (produto == null) {
            throw new EntityNotFoundException();
        }
        return Response.ok(produto).build();
    }
    
}
