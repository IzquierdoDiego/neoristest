/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdf.testdf.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author Kd-PC
 */
@Data
@Entity
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "NUMERO_CUENTA")
    private Integer numeroCuenta;
    @Column(name = "TIPO_CUENTA")
    private String tipoCuenta;
    @Column(name = "SALDO_INICIAL")
    private Integer saldoInicial;
    @Column(name = "ESTADO")
    private String estado;
    
//    @JsonBackReference("CLIREFE")
    @JoinColumn(name = "CLI_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cliente cliente;
  
}
