package com.msanti16.net.exceptions;

public class BadIntegerParsingException extends Exception {
    private String str;

    public BadIntegerParsingException(String msg, String str){
        super(msg);
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
