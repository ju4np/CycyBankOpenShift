package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.exceptions.BussinessException;
import com.fpmislata.banco.common.json.JsonConvert;
import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.persistencia.ClienteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {

    @Autowired
    ClienteDAO clienteDao;
    @Autowired
    JsonConvert jsonConvert;

    @RequestMapping(value = {"/Cliente/{idCliente}"}, method = RequestMethod.GET)
    public void read(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idCliente") int idCliente) throws IOException, SQLException {

        try {

            Cliente cliente = clienteDao.get(idCliente); //creo variable para pasarla abajo

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            String json = jsonConvert.toJson(cliente);

            httpServletResponse.getWriter().println(json);

        } catch (BussinessException bussinessException) {
            httpServletResponse.getWriter().println(bussinessException.getBussinessMessages().toString());
        } catch (IOException ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/Cliente/{idCliente}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idCliente") int idCliente) {

        try {

            clienteDao.delete(idCliente);

            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }
    }

    @RequestMapping(value = {"/Clientes"}, method = RequestMethod.GET)
    public void find(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws IOException {

        try {
            List<Cliente> clientes = clienteDao.findAll();

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            String json = jsonConvert.toJson(clientes);
            httpServletResponse.getWriter().println(json);

        } catch (BussinessException bussinessException) {
            httpServletResponse.getWriter().println(bussinessException.getBussinessMessages().toString());
        } catch (IOException ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }
    }

    @RequestMapping(value = {"/Cliente"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String json) throws IOException {

        try {

            Cliente cliente = (Cliente) jsonConvert.fromJson(json, Cliente.class);

            clienteDao.insert(cliente);

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            json = jsonConvert.toJson(cliente);
            httpServletResponse.getWriter().println(json);

        } catch (BussinessException bussinessException) {
            try {
                httpServletResponse.getWriter().println(bussinessException.getBussinessMessages().toString());
            } catch (IOException ex) {
                httpServletResponse.setContentType("text/plain; charset=UTF-8");
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch (IOException ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        }
    }

    @RequestMapping(value = {"/Cliente"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String json) {

        try {
            //Aqui transforma el json de la cabecera en un objeto java para poder insertarlo en la BBDD

            Cliente cliente = (Cliente) jsonConvert.fromJson(json, Cliente.class);

            //Lee la entidad que hay que actualizar y la guarda en un objeto
            clienteDao.update(cliente);  //Actualiza la entidad

            //Castea el objeto creado de nuevo a formato json para poder devolverlo
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            json = jsonConvert.toJson(cliente); //Aqui la variable creada
            httpServletResponse.getWriter().println(json);

        } catch (BussinessException bussinessException) {
            try {
                httpServletResponse.getWriter().println(bussinessException.getBussinessMessages().toString());
            } catch (IOException ex) {
                httpServletResponse.setContentType("text/plain; charset=UTF-8");
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch (IOException ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }

    }

}
