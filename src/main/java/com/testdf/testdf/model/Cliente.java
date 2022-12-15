/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdf.testdf.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Kd-PC
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente extends Persona {
    
    @Column(name = "CLIENTEID")
    private Integer clienteid;
    @Column(name = "CONTRASEÑA")
    private String contraseña;
    @Column(name = "ESTADO")
    private String estado;  

   
}
