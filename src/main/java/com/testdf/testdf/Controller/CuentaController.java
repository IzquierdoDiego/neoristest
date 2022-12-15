/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdf.testdf.Controller;

import com.testdf.testdf.model.Cuenta;
import com.testdf.testdf.service.CuentaServiceImpl;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Kd-PC
 */
@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    
    @Autowired 
    private CuentaServiceImpl cuentaServiceImpl;
    
    @GetMapping("/get")
    public List<Cuenta> list() {
        return cuentaServiceImpl.findAll();
    }
    
    @GetMapping("/get/{id}")
    public Cuenta get(@PathVariable int id) {
        return cuentaServiceImpl.findById(id);
    }
    
    @PutMapping("/put/{id}")
    public Cuenta put(@PathVariable int id, @RequestBody Cuenta cuenta) throws Exception {
        cuenta.setId(id);
        return cuentaServiceImpl.save(cuenta);
    }
    
    @PostMapping("/post")
    public Cuenta post(@RequestBody Cuenta cuenta) throws Exception {
        return cuentaServiceImpl.save(cuenta);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws Exception {
        return cuentaServiceImpl.deleteById(id);
    }
    
}
