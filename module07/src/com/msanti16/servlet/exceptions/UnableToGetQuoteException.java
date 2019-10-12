package com.msanti16.servlet.exceptions;

public class UnableToGetQuoteException extends Exception {
    private String response;

    public UnableToGetQuoteException(String msg, String response){
        super(msg);
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}
