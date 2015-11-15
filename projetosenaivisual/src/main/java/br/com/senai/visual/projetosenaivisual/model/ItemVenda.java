/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class ItemVenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    //@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    //@JoinColumn(name = "venda", nullable = false)
    //private Venda venda;
    @OneToOne
    @JoinColumn(name = "produto")
    private Produto produto;
    @Column
    private Double valorItem;

    public Long getId() {
        return id;
    }

    //public Venda getVenda() {
    //    return venda;
    //}

    //public void setVenda(Venda venda) {
    //    this.venda = venda;
    //}

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getValorItem() {
        return valorItem;
    }

    public void setValorItem(Double valorItem) {
        this.valorItem = valorItem;
    }
    
    

}
