/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdf.testdf.Controller;

import com.testdf.testdf.exception.ResourceNotFoundException;
import com.testdf.testdf.model.Cliente;
import com.testdf.testdf.service.ClenteServiceImpl;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Kd-PC
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired 
    private ClenteServiceImpl clenteServiceImpl;
    
    @GetMapping("/get")
    public List<Cliente> list() {
        return clenteServiceImpl.findAll();
    }
    
    @GetMapping("/get/{id}")
    public Cliente get(@PathVariable int id) {
        return clenteServiceImpl.findById(id);
    }
    
    @PutMapping("/put/{id}")
    public Cliente put(@PathVariable int id, @RequestBody Cliente cliente) throws Exception {
        cliente.setId(id);
        return clenteServiceImpl.save(cliente);
    }
    
    @PostMapping("/post")
    public Cliente post(@RequestBody Cliente cliente) throws Exception {
        return clenteServiceImpl.save(cliente);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws Exception {
        return clenteServiceImpl.deleteById(id);
    }
    
    
}
