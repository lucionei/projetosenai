/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.model;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Lucionei
 */
@XmlType
public enum TipoPessoa {

    FISICA("F"),
    JURIDICA("J");

    private final String tipo;

    TipoPessoa(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

}
