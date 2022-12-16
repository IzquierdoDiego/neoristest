/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdf.testdf.service;

import com.testdf.testdf.model.Cliente;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author Kd-PC
 */

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ClienteServiceImplTest {
    
    @Autowired
    private ClienteServiceImpl clenteServiceImpl;
    
    @Test
    void save() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNombre("Adrian");
        cliente.setEdad(31);
        cliente.setIdentificacion("54864");       
        
        Cliente clienteResponse = clenteServiceImpl.save(cliente);
             
        assertNotNull(clienteResponse.getId());
        
//        assertEquals(1, clienteResponse.getId());      
        
        
    }
    
    
}
