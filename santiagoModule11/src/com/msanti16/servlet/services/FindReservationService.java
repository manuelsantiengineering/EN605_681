package com.msanti16.servlet.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.SQLException;

import com.msanti16.servlet.domain.Reservation;
import com.msanti16.servlet.exceptions.BadIntegerParsingException;
import com.msanti16.servlet.exceptions.BadUserNameException;
import com.msanti16.servlet.repositories.MyDBConnection;
import com.msanti16.servlet.utils.GenerateErrorHtml;
import com.msanti16.servlet.repositories.MyDBConnection;
import com.msanti16.servlet.constants.DBConnectionConstants;

public class FindReservationService {
	
	//TODO Include the Repository Object
	
	public FindReservationService() {	super();	}
	
	public String findReservation(String startDate){
		try{
			
    	if(startDate.chars().filter(ch -> ch == '/').count() != 2) {
    		throw new BadIntegerParsingException("Incorrect date format", startDate);
    	}
    	
    	String[] parsedDate = startDate.split("/");
    	
    	if(parsedDate.length != 3) {
    		throw new BadIntegerParsingException("Incorrect date format", startDate);
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
      	throw new BadIntegerParsingException("Incorrect date format", startDate);
      }
        
      int month, day, year;
      try {
	      month = Integer.parseInt(parsedDate[0]) - 1; // Jan = 0, Dec = 11
	      day = Integer.parseInt(parsedDate[1]);
	      year = Integer.parseInt(parsedDate[2]);
      }catch (NumberFormatException exception){
      	System.err.println("Error: " + exception.getMessage());
        GenerateErrorHtml errorHtml = new GenerateErrorHtml(
        		"<title>Beartooth Hiking Company</title>",
        		"Make sure to use digits for the date values."
        		);
        errorHtml.generateHtml();
        return errorHtml.toString();
  		}
      
      Calendar calendarDate = Calendar.getInstance();
      calendarDate.set(year, month, day, 0, 0);      
      Date reservationDate = new Date(calendarDate.getTimeInMillis());
      
      Reservation reservation = new Reservation();
      reservation.setFirst("TOMATERO");
        
      ArrayList<Reservation> reservationList = MyDBConnection.initConnection(DBConnectionConstants.QUERY);
      System.out.println("Printing Reservation List");
      for (int i=0; i < reservationList.size(); i++) {
        System.out.println(reservationList.get(i) );
      }
        
      GenerateErrorHtml errorHtml = new GenerateErrorHtml(
      		"<title>Beartooth Hiking Company</title>",
      		"Just for testing until getting real results  " + reservationDate.toString()
      		);
      errorHtml.generateHtml();
      return errorHtml.toString();
        
        
		}catch (BadIntegerParsingException exception){
    	System.err.println("Error: " + exception.getMessage());
      GenerateErrorHtml errorHtml = new GenerateErrorHtml(
      		"<title>Beartooth Hiking Company</title>",
      		exception.getMessage()
      		);
      errorHtml.generateHtml();
      return errorHtml.toString();
		}catch (NumberFormatException exception){
    	System.err.println("Error: " + exception.getMessage());
      GenerateErrorHtml errorHtml = new GenerateErrorHtml(
      		"<title>Beartooth Hiking Company</title>",
      		"Error parsing values from database."
      		);
      errorHtml.generateHtml();
      return errorHtml.toString();
		}catch (BadUserNameException exception){
      System.err.println("Error: " + exception.getMessage());
      GenerateErrorHtml errorHtml = new GenerateErrorHtml(
      		"<title>Beartooth Hiking Company</title>",
      		exception.getMessage()
      		);
      errorHtml.generateHtml();
      return errorHtml.toString();
		}catch (SQLException exception) {
			System.err.println("Error: " + exception.getMessage());
      GenerateErrorHtml errorHtml = new GenerateErrorHtml(
      		"<title>Beartooth Hiking Company</title>",
      		"Unable to connect to the database."
      		);
      errorHtml.generateHtml();
      return errorHtml.toString();
		}
	}

}
