package com.msanti16.servlet.exceptions;

public class BadUserNameException extends Exception {
	private static final long serialVersionUID = 9137951669193253841L;
	private String username;

    public BadUserNameException(String msg, String username){
        super(msg);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
