package com.msanti16.servlet.utils;

import java.util.Date;

import com.msanti16.servlet.exceptions.BadIntegerParsingException;

import java.util.Calendar;

public class ConvertDate {

	public static Date convertStringFromDB(String strDate) 
			throws BadIntegerParsingException {
		
		if(strDate.chars().filter(ch -> ch == '-').count() != 2) {
  		throw new BadIntegerParsingException("Incorrect date format from DB", strDate);
  	}
  	
  	String[] parsedDate = strDate.split("-");
  	
  	if(parsedDate.length != 3) {
  		throw new BadIntegerParsingException("Incorrect date format from DB", strDate);
  	}
    if(parsedDate[0].isEmpty()){
        throw new BadIntegerParsingException("Reservation year from DB can't be empty", parsedDate[0]);
    }
    if(parsedDate[1].isEmpty()){
        throw new BadIntegerParsingException("Reservation month from DB can't be empty", parsedDate[1]);
    }
    if(parsedDate[2].isEmpty()){
        throw new BadIntegerParsingException("Reservation day from DB can't be empty", parsedDate[2]);
    }
    if(parsedDate[0].length() != 4 || parsedDate[1].length() > 2 || parsedDate[2].length() > 2){
    	throw new BadIntegerParsingException("Incorrect date format from DB", strDate);
    }
    
    int month, day, year;
    try {
    	year = Integer.parseInt(parsedDate[0]);
      month = Integer.parseInt(parsedDate[1]) - 1; // Jan = 0, Dec = 11
      day = Integer.parseInt(parsedDate[2]);      
    }catch (NumberFormatException exception){
    	throw new BadIntegerParsingException("Date from DB is not using digits", strDate);
		}
    
    Calendar calendarDate = Calendar.getInstance();
    calendarDate.set(year, month, day, 0, 0);  
		
    return new Date(calendarDate.getTimeInMillis());
	}
	
	public static Date convertStringFromClient(String strDate) 
			throws BadIntegerParsingException {
		
		if(strDate.chars().filter(ch -> ch == '/').count() != 2) {
  		throw new BadIntegerParsingException("Incorrect date format", strDate);
  	}
  	
  	String[] parsedDate = strDate.split("/");
  	
  	if(parsedDate.length != 3) {
  		throw new BadIntegerParsingException("Incorrect date format", strDate);
  	}
    if(parsedDate[0].isEmpty()){
        throw new BadIntegerParsingException("Reservation month can't be empty", parsedDate[0]);
    }
    if(parsedDate[1].isEmpty()){
        throw new BadIntegerParsingException("Reservation day can't be empty", parsedDate[1]);
    }
    if(parsedDate[2].isEmpty()){
        throw new BadIntegerParsingException("Reservation year can't be empty", parsedDate[2]);
    }
    if(parsedDate[0].length() > 2 || parsedDate[1].length() > 2 || parsedDate[2].length() != 4){
    	throw new BadIntegerParsingException("Incorrect date format", strDate);
    }
    
    int month, day, year;
    try {
      month = Integer.parseInt(parsedDate[0]) - 1; // Jan = 0, Dec = 11
      day = Integer.parseInt(parsedDate[1]);
      year = Integer.parseInt(parsedDate[2]);
    }catch (NumberFormatException exception){
    	throw new BadIntegerParsingException("Make sure date uses format mm/dd/yyyy", parsedDate[2]);
		}
    
    Calendar calendarDate = Calendar.getInstance();
    calendarDate.set(year, month, day, 0, 0);  
		
    return new Date(calendarDate.getTimeInMillis());
	}
	
	public static String convertStringFromClientToQuery(String strDate) 
			throws BadIntegerParsingException {
		
		if(strDate.chars().filter(ch -> ch == '/').count() != 2) {
  		throw new BadIntegerParsingException("Incorrect date format", strDate);
  	}
  	
  	String[] parsedDate = strDate.split("/");
  	
  	if(parsedDate.length != 3) {
  		throw new BadIntegerParsingException("Incorrect date format", strDate);
  	}
    if(parsedDate[0].isEmpty()){
        throw new BadIntegerParsingException("Reservation month can't be empty", parsedDate[0]);
    }
    if(parsedDate[1].isEmpty()){
        throw new BadIntegerParsingException("Reservation day can't be empty", parsedDate[1]);
    }
    if(parsedDate[2].isEmpty()){
        throw new BadIntegerParsingException("Reservation year can't be empty", parsedDate[2]);
    }
    if(parsedDate[0].length() != 2 || parsedDate[1].length() != 2 || parsedDate[2].length() != 4){
    	throw new BadIntegerParsingException("Incorrect date format", strDate);
    }
    
    try {
      Integer.parseInt(parsedDate[0]); // Month Jan = 0, Dec = 11
      Integer.parseInt(parsedDate[1]); // Day
      Integer.parseInt(parsedDate[2]); // Year
    }catch (NumberFormatException exception){
    	throw new BadIntegerParsingException("Make sure date uses format mm/dd/yyyy", parsedDate[2]);
		}
    
		
    return "\"" + parsedDate[2] + "-" + parsedDate[0] + "-" + parsedDate[1] + "\"";
	}
}
