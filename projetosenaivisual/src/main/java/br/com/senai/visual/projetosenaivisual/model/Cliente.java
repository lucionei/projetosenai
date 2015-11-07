/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.model;

import javax.persistence.Entity;

/**
 *
 * @author Lucionei
 */
@Entity
public class Cliente extends Pessoa{
    private String cpfCnpj;
    
}
