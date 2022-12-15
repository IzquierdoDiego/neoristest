/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdf.testdf.service;

import com.testdf.testdf.Dao.ICuentaDao;
import com.testdf.testdf.exception.ResourceNotFoundException;
import com.testdf.testdf.model.Cuenta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kd-PC
 */
@Service
public class CuentaServiceImpl {

    @Autowired
    private ICuentaDao iCuentaDao;
            
    public Cuenta save(Cuenta cuenta) throws Exception {
        Cuenta cuenta1 = new Cuenta();
        try {
            if (cuenta.getId() != null) {
                cuenta1 =  iCuentaDao.findById(cuenta.getId()).get();
            }            
        } catch (Exception e) {
            throw new Exception("No exite cuenta con id: " + cuenta.getId());
        }      
        
        
        try {
            return iCuentaDao.save(cuenta);
            
        } catch (Exception e) {
            throw new Exception("No fue posible guardar la cuenta ");
        }
    }
    
    public List<Cuenta> findAll() {
        return iCuentaDao.findAll();
    }

    public Cuenta findById(int id) {
        return iCuentaDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encuentra cuenta con id  : " + id));
    }

    public ResponseEntity<Void> deleteById(int id) throws Exception {
        try {
            iCuentaDao.deleteById(id);
            
        } catch (Exception e) {
            throw new Exception("No fue posible eliminar cuenta con id: " + id);
        }
        return ResponseEntity.noContent().build();   
    }
    
    public Integer consultarSaldo(int cuentaId) throws Exception{
        try {
            return iCuentaDao.findById(cuentaId).get().getSaldoInicial();
            
        } catch (Exception e) {
            throw new Exception("No fue posible encontrar cuenta con id: " + cuentaId);
        }
        
    }

   
    

    Integer actualizarSaldo(int nuevoSaldo, Integer cuentaId) {
        Cuenta cuenta = new Cuenta();
        cuenta = iCuentaDao.findById(cuentaId).get();
        cuenta.setSaldoInicial(nuevoSaldo);
        iCuentaDao.save(cuenta);
        return nuevoSaldo;
    }
    
}
