package com.fpmislata.banco.common.exceptions;

import java.util.List;

public class BussinessException extends Exception {

    private List<BussinessMessage> bussinessMessages;

    public BussinessException(String fieldName, String message) {
        BussinessMessage bussinessMessage = new BussinessMessage(fieldName, message);
        bussinessMessages.add(bussinessMessage);
    }

    public void setBussinessMessages(String fieldName, String message) {
        BussinessMessage bussinessMessage = new BussinessMessage(fieldName, message);
        bussinessMessages.add(bussinessMessage);
    }

    public List<BussinessMessage> getBussinessMessages() {
        return bussinessMessages;
    }
}
