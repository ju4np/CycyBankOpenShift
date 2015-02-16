package com.fpmislata.banco.common.exceptions;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

public class BussinessException extends Exception {

    private List<BussinessMessage> bussinessMessages= new ArrayList();

    public BussinessException(String fieldName, String message) {
        BussinessMessage bussinessMessage = new BussinessMessage(fieldName, message);
        bussinessMessages.add(bussinessMessage);
    }
    
    public BussinessException(BussinessMessage bussinessMessage){
        bussinessMessages.add(bussinessMessage);
    };
    
    public BussinessException(ConstraintViolationException constraintViolationException){
       for(ConstraintViolation constraintViolation: constraintViolationException.getConstraintViolations()){
           BussinessMessage bussinessMessage = new BussinessMessage(
                   constraintViolation.getPropertyPath()+"",
                   constraintViolation.getMessage()
           );
           bussinessMessages.add(bussinessMessage);
       } 
    };
    
    public void setBussinessMessages(String fieldName, String message) {
        BussinessMessage bussinessMessage = new BussinessMessage(fieldName, message);
        bussinessMessages.add(bussinessMessage);
    }

    public List<BussinessMessage> getBussinessMessages() {
        return bussinessMessages;
    }
   
}