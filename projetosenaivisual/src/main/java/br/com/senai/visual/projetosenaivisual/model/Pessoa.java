/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.visual.projetosenaivisual.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucionei
 */
/*@Entity
@Table(name="PESSOA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@XmlRootElement*/
public abstract class Pessoa implements Serializable {
   
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column*/
    private Long id;
    //@Column
    private String nome;
    //@Column
    private String email;
    //@Column
    private String telefone;
    
    
}
