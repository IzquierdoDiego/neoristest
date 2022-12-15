/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdf.testdf.service;

import com.testdf.testdf.Dao.IMovimientoDao;
import com.testdf.testdf.Dto.ReporteDto;
import com.testdf.testdf.exception.ResourceNotFoundException;
import com.testdf.testdf.model.Cuenta;
import com.testdf.testdf.model.Movimiento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kd-PC
 */
@Service
public class MovimientoServiceImpl {

    @Autowired
    private IMovimientoDao iMovimientoDao;
    
    @Autowired
    private CuentaServiceImpl cuentaServiceImpl;
    
            
    public Movimiento save(Movimiento movimiento) throws Exception {
        Movimiento movimiento1 = new Movimiento();
        try {
            if (movimiento.getId() != null) {
                movimiento1 =  iMovimientoDao.findById(movimiento.getId()).get();
            }            
        } catch (Exception e) {
            throw new Exception("No exite Movimiento con id: " + movimiento.getId());
        } 
        
        movimiento.setTipoMovimiento(valorarTipoMovimiento(movimiento.getValor()));
        movimiento.setSaldo(calcularNuevoSaldo(movimiento.getCuenta(), movimiento.getValor()));
        try {
            return iMovimientoDao.save(movimiento);
            
        } catch (Exception e) {
            throw new Exception("No fue posible guardar el movimiento ");
        }
    }

    public List<Movimiento> findAll() {
        return iMovimientoDao.findAll();
    }
    
    public Movimiento findById(int id) {
        return iMovimientoDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encuentra movimiento con id : " + id));
    }

    public ResponseEntity<Void> deleteById(int id) throws Exception {
        try {
            iMovimientoDao.deleteById(id);
            
        } catch (Exception e) {
            throw new Exception("No fue posible eliminar movimiento con id: " + id);
        }
        return ResponseEntity.noContent().build();
    }

    private String valorarTipoMovimiento(Integer valor) {
        if (valor >= 0) {
            return "Crédito";
        }else{
            return "Débito";            
        }
    }

    private Integer calcularNuevoSaldo(Cuenta cuenta, Integer valor) throws Exception  {
        int saldo = cuentaServiceImpl.consultarSaldo(cuenta.getId());
        if (saldo == 0  || saldo + valor <= 0) {
            throw new Exception("Saldo no disponible");
        }
        
//        return cuentaServiceImpl.actualizarSaldo(saldo + valor, cuenta.getId());
        return saldo + valor;
    }

    public List<ReporteDto> generaReporte(int usuarioId, String fechaInicial, String fechaFinal) throws Exception {
        ReporteDto reporteDto = new ReporteDto();
        List<ReporteDto> reportesDto = new ArrayList();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicialb = formato.parse(fechaInicial);
        Date fechaFinalb = formato.parse(fechaFinal);
        List<Movimiento> movimientos = iMovimientoDao.findByFechaBetween(fechaInicialb, fechaFinalb);
        
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getCuenta().getCliente().getId() == usuarioId) {
                reporteDto.setFecha(movimiento.getFecha().toString());
                reporteDto.setFecha(movimiento.getCuenta().getCliente().getNombre());            
                reporteDto.setNumeroCuenta(movimiento.getCuenta().getNumeroCuenta());
                reporteDto.setTipoCuenta(movimiento.getCuenta().getTipoCuenta());
                reporteDto.setSaldoInicial(movimiento.getCuenta().getSaldoInicial());
                reporteDto.setEstadoCuenta(movimiento.getCuenta().getEstado());
                reporteDto.setMovimiento(movimiento.getValor());
                reporteDto.setSaldoDisponible(movimiento.getSaldo());
            
                reportesDto.add(reporteDto);
                reporteDto = new ReporteDto(); 
            }                       
            
        }
        return reportesDto;
    }
    
}
