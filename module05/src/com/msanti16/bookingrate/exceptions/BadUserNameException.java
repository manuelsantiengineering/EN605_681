package com.msanti16.bookingrate.exceptions;

public class BadUserNameException extends Exception {
    private String username;

    public BadUserNameException(String msg, String username){
        super(msg);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
