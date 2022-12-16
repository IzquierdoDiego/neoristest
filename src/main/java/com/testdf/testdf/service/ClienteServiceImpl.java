/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdf.testdf.service;

import com.testdf.testdf.Dao.IClienteDao;
import com.testdf.testdf.exception.ResourceNotFoundException;
import com.testdf.testdf.model.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kd-PC
 */
@Service
public class ClienteServiceImpl {
    
    @Autowired
    private IClienteDao clienteDao;
    
    public Cliente save(Cliente cliente) throws Exception{
        Cliente cliente1 = new Cliente();
        try {
            if (cliente.getId() != null) {
                cliente1 =  clienteDao.findById(cliente.getId()).get();
            }            
        } catch (Exception e) {
            throw new Exception("No exite cliente con id: " + cliente.getId());
        }
            
        try {
            return clienteDao.save(cliente);            
        } catch (Exception e) {
            throw new Exception("No fue posible guardar el cliente ");
        }
    }

    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    public Cliente findById(int id) {
        return clienteDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encuentra cliente con id : " + id));
    }

    public ResponseEntity<Void> deleteById(int id) throws Exception {
        try {
            clienteDao.deleteById(id);
            
        } catch (Exception e) {
            throw new Exception("No fue posible eliminar cliente con id: " + id);
        }
        return ResponseEntity.noContent().build();
    }
}
