package com.gwt.msanti16.bhc.server;

import com.gwt.msanti16.bhc.client.GreetingService;
import com.gwt.msanti16.bhc.exceptions.BadBookingDateException;
import com.gwt.msanti16.bhc.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.msanti16.bhc.services.BookingDay;
import com.gwt.msanti16.bhc.services.GenerateCompletedReservationHtml;
import com.gwt.msanti16.bhc.services.Rates;

@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
	private final String[]	TOURS = {"Gardiner Lake", "Hellroaring Plateau", "The Beaten Path"};
	
	public String greetServer(
			String nameToServer, 
			String startDateToServer,
			int durationToServer,
			int partySizeToServer,
			int hikeId
			) throws IllegalArgumentException {
		try {
			if (!FieldVerifier.isValidName(nameToServer)) {
				throw new IllegalArgumentException("Name must be at least 4 characters long");
			}
			if (FieldVerifier.isValidDate(startDateToServer).length() != 0) {
				throw new IllegalArgumentException(FieldVerifier.isValidDate(startDateToServer));
			}
			if (FieldVerifier.isValidPartySize(""+partySizeToServer).length() != 0 ) {
				throw new IllegalArgumentException(FieldVerifier.isValidPartySize(""+partySizeToServer));
			}
			if (!FieldVerifier.isValidHikeId(hikeId) ) {
				throw new IllegalArgumentException("Invalid Hike Id");
			}
	
			String userAgent = getThreadLocalRequest().getHeader("User-Agent");
	
			// Escape data from the client to avoid cross-site script vulnerabilities.
			nameToServer = escapeHtml(nameToServer);
			startDateToServer = escapeHtml(startDateToServer);		
			userAgent = escapeHtml(userAgent);
			
			String[] parsedDate = startDateToServer.split("-");
	    int year = Integer.parseInt(parsedDate[0]);
			int month = Integer.parseInt(parsedDate[1]);
	    int day = Integer.parseInt(parsedDate[2]);
	    BookingDay startDate;
	    Rates rates;
	    
	    switch(hikeId) {
		    case 1:
		    	rates = new Rates(Rates.HIKE.HELLROARING);
		    	break;
		    case 2:
		    	rates = new Rates(Rates.HIKE.BEATEN);
		    	break;
		    case 0:
		    default:
		    	rates = new Rates(Rates.HIKE.GARDINER); 
		    	break;
	    }
    	startDate = new BookingDay(year, month, day);
    	rates.setBeginDate(startDate);
    	rates.setDuration(durationToServer);
	    
	    if(!rates.isValidDates()){
	    	System.out.println("Details:" + rates.getDetails());
	        return
	        		"Selected dates (" + startDate.getMonth() + "/" + startDate.getDayOfMonth() + ") " +
	        		"are out of the season. " +
	        		"Season is from: " + rates.getSeasonStart() + 
	        		" to " + rates.getSeasonEnd() 
	        		;
	    }
	    
	    System.out.println(startDate);
	    System.out.println(rates.getBeginDate());
	    double totalCost = rates.getCost() * partySizeToServer;
	    
			GenerateCompletedReservationHtml completedReservationHtml 
			= new GenerateCompletedReservationHtml(
					"<title>Beartooth Hiking Company</title>",
					nameToServer,
					startDateToServer,
					TOURS[hikeId],
					new String(partySizeToServer + ""),
					new String(partySizeToServer + ""),
					String.format("%.2f", totalCost)
					);
			completedReservationHtml.generateHtml();
			return completedReservationHtml.toString();
		
		}catch(BadBookingDateException ex ) {
	  	return ex.getMessage();
	  }
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
