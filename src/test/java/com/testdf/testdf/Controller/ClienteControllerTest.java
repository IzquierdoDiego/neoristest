/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdf.testdf.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.testdf.testdf.model.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 *
 * @author Kd-PC
 */
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ClienteControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
     
    
    @Test
    void list() throws Exception {
        mockMvc.perform(get("/clientes/get")).andExpect(status().isOk());
    }
    
    
    @Test
    void post() throws Exception {
        String cliente = "{\n" +
                            "    \"nombre\": \"caamila\",\n" +
                            "    \"genero\": \"Femenino\",\n" +
                            "    \"edad\": 23,\n" +
                            "    \"identificacion\": \"41563333\",\n" +
                            "    \"direccion\": \"cale 12323\",\n" +
                            "    \"telefono\": 51125,\n" +
                            "    \"clienteid\": 1116,\n" +
                            "    \"contraseña\": \"camadef3.d*\",\n" +
                            "    \"estado\": \"Activo\"\n" +
                            "}";
        
        mockMvc.perform( MockMvcRequestBuilders
	      .post("/clientes/post")
	      .content(cliente)
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
        
    }
    
    
    
    
}
