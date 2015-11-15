/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucionei
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @OneToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;
    @Temporal(TemporalType.DATE)
    @Column
    private Date dataEmissao;
    //@OneToMany(mappedBy = "venda")
    //private List<ItemVenda> itemVenda = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    //public List<ItemVenda> getItemVenda() {
        //return itemVenda;
    //}

    //public void setItemVenda(List<ItemVenda> itemVenda) {
        //this.itemVenda = itemVenda;
    //}
    
    //public void addItemVenda(ItemVenda itemVenda) {
        //this.itemVenda.add(itemVenda);
    //}
    
    //public void revoveItemVenda(ItemVenda itemVenda) {
        //this.itemVenda.remove(itemVenda);
    //}
    
}
