package com.msanti16.servlet.exceptions;

public class BadIntegerParsingException extends Exception {
	private static final long serialVersionUID = 6769034512881136587L;
	private String str;

    public BadIntegerParsingException(String msg, String str){
        super(msg);
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
