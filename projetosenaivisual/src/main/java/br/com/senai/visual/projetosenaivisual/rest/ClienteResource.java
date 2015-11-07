/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.rest;

import br.com.senai.visual.projetosenaivisual.dao.ClienteDAO;
import br.com.senai.visual.projetosenaivisual.model.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    
}
