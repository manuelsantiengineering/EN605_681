package com.msanti16.servlet.services;

import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;

import com.msanti16.servlet.utils.ConvertDate;
import com.msanti16.servlet.exceptions.BadIntegerParsingException;
import com.msanti16.servlet.exceptions.BadUserNameException;
import com.msanti16.servlet.repositories.MyDBConnection;
import com.msanti16.servlet.utils.GenerateFoundReservationHtml;
import com.msanti16.servlet.constants.DBConnectionConstants;
import com.msanti16.servlet.domain.Reservation;

public class FindReservationService {
	
	//TODO Include the Repository Object
	
	public FindReservationService() {	super();	}
	
	public String findReservation(String startDate){
		try{
			 
      Date reservationDate = ConvertDate.convertStringFromClient(startDate);
              
      ArrayList<Reservation> reservationList = MyDBConnection.initConnection(DBConnectionConstants.QUERY);
        
      GenerateFoundReservationHtml errorHtml = 
      		new GenerateFoundReservationHtml(
      		"<title>Beartooth Hiking Company</title>",
      		reservationList
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
