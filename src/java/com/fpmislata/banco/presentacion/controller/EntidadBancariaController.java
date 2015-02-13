package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.exceptions.BussinessException;
import com.fpmislata.banco.common.json.JsonConvert;
import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.EntidadBancariaDAO;
import com.fpmislata.banco.persistencia.SucursalBancariaDAO;
import java.io.IOException;
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
public class EntidadBancariaController {

    @Autowired // va al applicationContext.xml a buscar la implementacion
    EntidadBancariaDAO entidadBancariaDAO;
    @Autowired
    SucursalBancariaDAO sucursalBancariaDAO;

    @Autowired // va al applicationContext.xml a buscar la implementacion
    JsonConvert jsonConvert;

    @RequestMapping(value = {"/EntidadBancaria/{idEntidadBancaria}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidadBancaria") int idEntidadBancaria) {
        try {
            EntidadBancaria entidadBancaria = entidadBancariaDAO.get(idEntidadBancaria);

            if (entidadBancaria == null) {
                httpServletResponse.setStatus(204);
            } else {
                httpServletResponse.setStatus(200);
                httpServletResponse.getWriter().println(jsonConvert.toJson(entidadBancaria));
            }
        } catch (BussinessException bussinessException) {
            try {
                httpServletResponse.getWriter().println(bussinessException.getBussinessMessages().toString());
            } catch (IOException ex) {
                httpServletResponse.setContentType("text/plain; charset=UTF-8");
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @RequestMapping(value = {"/EntidadBancaria/{idEntidadBancaria}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidadBancaria") int idEntidadBancaria) {
        try {
            entidadBancariaDAO.delete(idEntidadBancaria);
            httpServletResponse.setStatus(204);
        } catch (BussinessException bussinessException) {
            try {
                httpServletResponse.getWriter().println(bussinessException.getBussinessMessages().toString());
            } catch (IOException ex) {
                httpServletResponse.setContentType("text/plain; charset=UTF-8");
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }

    }

    @RequestMapping(value = {"/EntidadBancaria"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            entidadBancariaDAO.insert((EntidadBancaria) jsonConvert.fromJson(jsonEntrada, EntidadBancaria.class));
//        httpServletResponse.setStatus(204);
        } catch (BussinessException bussinessException) {
            try {
                httpServletResponse.getWriter().println(bussinessException.getBussinessMessages().toString());
            } catch (IOException ex) {
                httpServletResponse.setContentType("text/plain; charset=UTF-8");
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(value = {"/EntidadBancaria"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            entidadBancariaDAO.update((EntidadBancaria) jsonConvert.fromJson(jsonEntrada, EntidadBancaria.class));
//        httpServletResponse.setStatus(204);
        } catch (BussinessException bussinessException) {
            try {
                httpServletResponse.getWriter().println(bussinessException.getBussinessMessages().toString());
            } catch (IOException ex) {
                httpServletResponse.setContentType("text/plain; charset=UTF-8");
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(value = {"/EntidadBancaria"})
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {

            List entidadesBancarias = entidadBancariaDAO.findAll();
            httpServletResponse.getWriter().println(jsonConvert.toJson(entidadesBancarias));

        } catch (BussinessException bussinessException) {
            try {
                httpServletResponse.getWriter().println(bussinessException.getBussinessMessages().toString());
            } catch (IOException ex) {
                httpServletResponse.setContentType("text/plain; charset=UTF-8");
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @RequestMapping(value = {"/EntidadBancaria/{idEntidadBancaria}/Sucursales"})
    public void getSucursalesByIdEntidad(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidadBancaria") int idEntidadBancaria) {
        try {

            List sucursalesBancarias = sucursalBancariaDAO.getSucursales(idEntidadBancaria);
            httpServletResponse.getWriter().println(jsonConvert.toJson(sucursalesBancarias));
        } catch(BussinessException bussinessException){
            try{
                httpServletResponse.getWriter().print(bussinessException.getBussinessMessages());
            } catch(IOException ex){
                httpServletResponse.setContentType("text/plain; charset=UTF-8");
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } 
    }

}
