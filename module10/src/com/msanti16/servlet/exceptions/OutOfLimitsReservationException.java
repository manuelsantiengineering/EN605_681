package com.msanti16.servlet.exceptions;

public class OutOfLimitsReservationException extends Exception {	
	private static final long serialVersionUID = -5153220092724834736L;
	private int str;

    public OutOfLimitsReservationException(String msg, int str){
        super(msg);
        this.str = str;
    }

    public int getStr() {
        return str;
    }
}
