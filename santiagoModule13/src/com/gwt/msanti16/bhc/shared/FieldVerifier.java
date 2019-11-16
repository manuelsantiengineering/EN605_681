package com.gwt.msanti16.bhc.shared;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> package because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is not translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client-side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}		
		return name.length() > 3 && name.matches("^[a-zA-Z]*$");
	}
	
	public static boolean isValidHikeId(int hikeId) {
		return hikeId >= 0 && hikeId < 3;
	}
	
	public static String isValidDate(String dateString) {
		String[] parsedDate = dateString.split("-");
  	if(parsedDate.length != 3) {
			return "Please use yyyy-mm-dd format";
  	}
  	for(int i = 0; i < parsedDate.length; i++) {
  		parsedDate[i] = parsedDate[i].trim(); 
  	}
    if(parsedDate[0].isEmpty()){
    	return "Reservation year can't be empty (yyyy-mm-dd)";
    }
    if(parsedDate[1].isEmpty()){
    	return "Reservation month can't be empty (yyyy-mm-dd)";
    }
    if(parsedDate[2].isEmpty()){    	
    	return "Reservation day can't be empty (yyyy-mm-dd)";
    }
    if(parsedDate[0].length() != 4 || parsedDate[1].length() > 2 || parsedDate[2].length() > 2){
    	return "Please use yyyy-mm-dd format";
    }
    return "";
	}
	
	public static String isValidPartySize(String value) {
		try {
			int initialNumberOfPeople = Integer.parseInt(value.trim());
			if(initialNumberOfPeople <= 0 || initialNumberOfPeople > 10) {
				return "Party size must be between 1 and 10";
			}else {
				return "";
			}
		}catch(NumberFormatException ex) {
			return "Make sure to use digit value for the party size";
		}		
	}
	
	public static String isValidDuration(String value) {
		try {
			Integer.parseInt(value.trim());
			return "";
		}catch(NumberFormatException ex) {
			return "Make sure to use digit value for the duration";
		}		
	}
	
}
