package com.fpmislata.banco.presentacion.controller;

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
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try{
            Transaccion transaccion = (Transaccion) jsonConvert.fromJson(jsonEntrada, Transaccion.class);
            Cuenta cuentaDestino = cuentaDAO.get(transaccion.getCuentaDestino());

            if (transaccion.getPin() == cuentaDestino.getPin()) {
                MovimientoBancario movimientoBancario = new MovimientoBancario();
                movimientoBancario.setCuentaOrigen(transaccion.getCuentaOrigen());
                movimientoBancario.setCuentaDestino(transaccion.getCuentaDestino());
                movimientoBancario.setCantidad(transaccion.getCantidad());
                movimientoBancario.setMotivo(transaccion.getConcepto());
                movimientoBancario.setTipoMovimientoBancario(TipoMovimientoBancario.DEBE);

                movimientoBancario = movimientoBancarioDAO.insert(movimientoBancario);

                MovimientoBancario movimientoBancarioHaber = new MovimientoBancario();
                movimientoBancarioHaber.setCuentaDestino(transaccion.getCuentaOrigen());
                movimientoBancarioHaber.setCuentaOrigen(transaccion.getCuentaDestino());
                movimientoBancarioHaber.setCantidad(transaccion.getCantidad());
                movimientoBancarioHaber.setTipoMovimientoBancario(TipoMovimientoBancario.HABER);
                movimientoBancarioHaber.setMotivo(transaccion.getConcepto());
                System.out.println(jsonConvert.toJson(movimientoBancarioHaber));
                System.out.println(jsonConvert.toJson(movimientoBancario));
            
                movimientoBancarioDAO.insert(movimientoBancarioHaber);

        }catch(Exception ex){
                httpServletResponse.getWriter().println(jsonEntrada);
        }
    }
}
