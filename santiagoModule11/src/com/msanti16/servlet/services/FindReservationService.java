package com.msanti16.servlet.services;

import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;

import com.msanti16.servlet.utils.ConvertDate;
//import com.msanti16.servlet.domain.Reservation;
import com.msanti16.servlet.exceptions.BadIntegerParsingException;
import com.msanti16.servlet.exceptions.BadUserNameException;
import com.msanti16.servlet.repositories.MyDBConnection;
import com.msanti16.servlet.utils.GenerateErrorHtml;
import com.msanti16.servlet.constants.DBConnectionConstants;

public class FindReservationService {
	
	//TODO Include the Repository Object
	
	public FindReservationService() {	super();	}
	
	public String findReservation(String startDate){
		try{
			 
      Date reservationDate = ConvertDate.convertStringFromClient(startDate);
              
      ArrayList<?> reservationList = MyDBConnection.initConnection(DBConnectionConstants.QUERY);
//      System.out.println("Printing Reservation List");
//      for (int i=0; i < reservationList.size(); i++) {
//        System.out.println(reservationList.get(i) );
//      }
        
      GenerateErrorHtml errorHtml = new GenerateErrorHtml(
      		"<title>Beartooth Hiking Company</title>",
      		"Just for testing until getting real results  " + reservationDate.toString()
      		);
      errorHtml.generateHtml();
      return errorHtml.toString();
        
        
		}catch (BadIntegerParsingException exception){
    	System.err.println("Error: " + exception.getMessage() + " " + exception.getStr() );
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
