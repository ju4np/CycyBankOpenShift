package com.fpmislata.banco.presentacion.controller.commons;

import com.fpmislata.banco.common.exceptions.BussinessException;
import com.fpmislata.banco.common.exceptions.BussinessMessage;
import com.fpmislata.banco.common.json.JsonConvert;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class BussinessMessagesConvert {

    public static void toJson(BussinessException be, HttpServletResponse httpServletResponse, JsonConvert jsonConvert) {
        try {
            List<BussinessMessage> bussinessMessages = be.getBussinessMessages();
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            String json = jsonConvert.toJson(bussinessMessages);
            httpServletResponse.getWriter().println(json);
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
