package com.msanti16.servlet.exceptions;

public class BadBookingDateException extends Exception {
	private static final long serialVersionUID = 6203239987795277648L;
	private int value;

    public BadBookingDateException(String msg, int value){
        super(msg);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
