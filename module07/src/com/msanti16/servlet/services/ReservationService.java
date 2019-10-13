package com.msanti16.servlet.services;

import com.msanti16.servlet.constants.*;
import com.msanti16.servlet.domain.BookingDay;
import com.msanti16.servlet.domain.Rates;
import com.msanti16.servlet.domain.Reservation;
import com.msanti16.servlet.exceptions.*;
import com.msanti16.servlet.utils.GenerateErrorHtml;
import com.msanti16.servlet.utils.GenerateCompletedReservationHtml;

import java.util.Date;

public class ReservationService {    
    private Reservation     reservation;

    public ReservationService() {	super();	}

    public String createReservation(
            String username, String tourName,
            String reservationDate, String tourDuration
    ){
        System.out.println("Creating Reservation");
        try{
        	if(reservationDate.chars().filter(ch -> ch == '/').count() != 3) {
        		throw new BadIntegerParsingException("Incorrect date format", reservationDate);
        	}
        	String[] parsedDate = reservationDate.split("/");
        	if(parsedDate.length != 3) {
        		throw new BadIntegerParsingException("Incorrect date format", reservationDate);
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
            
            int month = Integer.parseInt(parsedDate[0]);
            int day = Integer.parseInt(parsedDate[1]);
            int year = Integer.parseInt(parsedDate[2]);
            int duration = Integer.parseInt(tourDuration);
            
            Rates rates;
            int tourId;            
            if(tourName.equals(ReservationConstants.TOURS[1])) {
            	tourId = 1;
                rates = new Rates(Rates.HIKE.HELLROARING);
            }else if(tourName.equals(ReservationConstants.TOURS[2])) {
            	tourId = 2;
                rates = new Rates(Rates.HIKE.BEATEN);
            }else {
            	tourId = 0;
                rates = new Rates(Rates.HIKE.GARDINER);                
            }
            rates.setBeginDate(reservation.getStartDate());
            rates.setDuration(duration);
            
            BookingDay startDate = new BookingDay(year, month, day);
            this.reservation = new Reservation();
            this.reservation.setUsername(username);
            this.reservation.setTourName(tourId);
            this.reservation.setStartDate(startDate);
            this.reservation.setDuration(duration);
            this.reservation.setCreatedAt(new Date());
                        
            if(!rates.isValidDates()){
                throw new OutOfSeasonException("Selected dates are out of the season.");
            }
            
            this.reservation.setTotalCost(rates.getCost());

            GenerateCompletedReservationHtml reservationHtml = 
            		new GenerateCompletedReservationHtml(
            				"<title>Beartooth Hiking Company</title>",
            				this.reservation.getUsername(),
            				reservationDate,
            				tourName,
            				tourDuration,
            				this.reservation.getCreatedAt().toString(),
            				this.reservation.getTotalCostString()
            				);
            reservationHtml.generateHtml();
            return reservationHtml.toString();
        }catch (BadUserNameException exception){
            System.err.println("Error: " + exception.getMessage());
            GenerateErrorHtml errorHtml = new GenerateErrorHtml(
            		"<title>Beartooth Hiking Company</title>",
            		exception.getMessage()
            		);
            errorHtml.generateHtml();
            return errorHtml.toString();
        }catch (BadBookingDateException exception){
        	System.err.println("Error: " + exception.getMessage());
            GenerateErrorHtml errorHtml = new GenerateErrorHtml(
            		"<title>Beartooth Hiking Company</title>",
            		exception.getMessage()
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
            		exception.getMessage()
            		);
            errorHtml.generateHtml();
            return errorHtml.toString();
        }catch (OutOfSeasonException exception){
        	System.err.println("Error: " + exception.getMessage());
            GenerateErrorHtml errorHtml = new GenerateErrorHtml(
            		"<title>Beartooth Hiking Company</title>",
            		exception.getMessage()
            		);
            errorHtml.generateHtml();
            return errorHtml.toString();
        }catch (NullPointerException exception){
        	System.err.println("Error: " + exception.getMessage());
            GenerateErrorHtml errorHtml = new GenerateErrorHtml(
            		"<title>Beartooth Hiking Company</title>",
            		exception.getMessage()
            		);
            errorHtml.generateHtml();
            return errorHtml.toString();
        }
    }

}
