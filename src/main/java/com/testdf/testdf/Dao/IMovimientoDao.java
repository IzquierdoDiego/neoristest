/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdf.testdf.Dao;

import com.testdf.testdf.model.Movimiento;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kd-PC
 */
@Repository
public interface IMovimientoDao extends JpaRepository<Movimiento,Integer>{

    public List<Movimiento> findByFechaBetween(Date fechaInicial, Date fechaFinal);
    
}
