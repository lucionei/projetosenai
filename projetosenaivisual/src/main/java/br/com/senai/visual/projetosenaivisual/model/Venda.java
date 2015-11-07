/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Lucionei
 */
public class Venda {
    
    private Long id;
    private Cliente cliente;
    private Date dataEmissao;
    private List<ItemVenda> itemVenda;
    
}
