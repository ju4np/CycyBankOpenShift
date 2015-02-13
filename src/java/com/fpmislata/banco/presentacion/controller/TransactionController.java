package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.exceptions.BussinessException;
import com.fpmislata.banco.common.json.JsonConvert;
import com.fpmislata.banco.dominio.Cuenta;
import com.fpmislata.banco.dominio.MovimientoBancario;
import com.fpmislata.banco.dominio.TipoMovimientoBancario;
import com.fpmislata.banco.dominio.Transaccion;
import com.fpmislata.banco.persistencia.CuentaDAO;
import com.fpmislata.banco.persistencia.MovimientoBancarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TransactionController {

    @Autowired
    JsonConvert jsonConvert;

    @Autowired
    MovimientoBancarioDAO movimientoBancarioDAO;

    @Autowired
    CuentaDAO cuentaDAO;

    @RequestMapping(value = {"/Transaccion"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws BussinessException, IOException {

            Transaccion transaccion = (Transaccion) jsonConvert.fromJson(jsonEntrada, Transaccion.class);

            Cuenta cuentaOrigen = cuentaDAO.getCuentaByCuentaBancaria(transaccion.getCuentaOrigen());
            Cuenta cuentaDestino = cuentaDAO.getCuentaByCuentaBancaria(transaccion.getCuentaDestino());
            
            if(cuentaDestino!=null){
                if(cuentaDestino.getPin() == transaccion.getPin()){
                    MovimientoBancario movimientoBancarioDebe = new MovimientoBancario();
                    movimientoBancarioDebe.setCuentaOrigen(cuentaOrigen.getIdCuenta());
                    movimientoBancarioDebe.setCuentaDestino(cuentaDestino.getIdCuenta());
                    movimientoBancarioDebe.setCantidad(transaccion.getCantidad());
                    movimientoBancarioDebe.setMotivo(transaccion.getConcepto());
                    movimientoBancarioDebe.setTipoMovimientoBancario(TipoMovimientoBancario.DEBE);
                    
                    movimientoBancarioDAO.insert(movimientoBancarioDebe);
                    
                    MovimientoBancario movimientoBancarioHaber = new MovimientoBancario();
                    movimientoBancarioHaber.setCuentaOrigen(cuentaDestino.getIdCuenta());
                    movimientoBancarioHaber.setCuentaDestino(cuentaOrigen.getIdCuenta());
                    movimientoBancarioHaber.setCantidad(transaccion.getCantidad());
                    movimientoBancarioHaber.setMotivo(transaccion.getConcepto());
                    movimientoBancarioHaber.setTipoMovimientoBancario(TipoMovimientoBancario.HABER);
                    
                    movimientoBancarioDAO.insert(movimientoBancarioHaber);
                } else{
                    httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    httpServletResponse.getWriter().println("Error 401: No Autorizado, PIN Incorrecto. ");
                }
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
                httpServletResponse.getWriter().println("Error 400: No Encontrado, Cuenta Origen o Destino incorrectas. ");
            }
    }
}
