package com.msanti16.servlet.exceptions;

public class UnableToGetQuoteException extends Exception {
	private static final long serialVersionUID = 6431193046740992861L;
	private String response;

    public UnableToGetQuoteException(String msg, String response){
        super(msg);
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}
