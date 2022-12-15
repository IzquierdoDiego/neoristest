/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdf.testdf.Dto;

import lombok.Data;

/**
 *
 * @author Kd-PC
 */

@Data
public class ReporteDto {
    public String fecha;
    public String cliente;
    public Integer numeroCuenta;
    public String tipoCuenta;
    public Integer saldoInicial;
    public String estadoCuenta;
    public Integer movimiento;
    public Integer saldoDisponible;    
    
}
