package com.msanti16.net.exceptions;

public class BadBookingDateException extends Exception {
    private int value;

    public BadBookingDateException(String msg, int value){
        super(msg);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
