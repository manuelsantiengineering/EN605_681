package com.msanti16.servlet.exceptions;

public class OutOfSeasonException extends Exception {
	private static final long serialVersionUID = 2627699584240241045L;

	public OutOfSeasonException(String msg){
        super(msg);
    }
}
