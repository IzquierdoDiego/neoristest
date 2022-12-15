/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdf.testdf.Controller;

import com.testdf.testdf.Dto.ReporteDto;
import com.testdf.testdf.model.Movimiento;
import com.testdf.testdf.service.MovimientoServiceImpl;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Kd-PC
 */
@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    
    @Autowired 
    private MovimientoServiceImpl movimientoServiceImpl;
    
    @GetMapping("/get")
    public List<Movimiento> list() {
        return movimientoServiceImpl.findAll();
    }
    
    @GetMapping("/estadoCuenta/reporte/{usuarioId}")
    public List<ReporteDto> reporte(@PathVariable int usuarioId, @RequestParam String fechaInicial,  @RequestParam String fechaFinal ) throws Exception {
        return movimientoServiceImpl.generaReporte(usuarioId, fechaInicial, fechaFinal);
    }
    
    @GetMapping("/get/{id}")
    public Movimiento get(@PathVariable int id) {
        return movimientoServiceImpl.findById(id);
    }
    
    @PutMapping("/put/{id}")
    public Movimiento put(@PathVariable int id, @RequestBody Movimiento movimiento) throws Exception {
        movimiento.setId(id);
        return movimientoServiceImpl.save(movimiento);
    }
    
    @PostMapping("/post")
    public Movimiento post(@RequestBody Movimiento movimiento) throws Exception {
        return movimientoServiceImpl.save(movimiento);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws Exception {
        return movimientoServiceImpl.deleteById(id);
    }
    
}
