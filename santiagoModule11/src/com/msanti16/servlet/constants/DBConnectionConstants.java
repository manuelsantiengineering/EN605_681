package com.msanti16.servlet.constants;

public interface DBConnectionConstants {

//  final String		URL                            		= "jdbc:mysql://localhost:3306/";
//  final String		DB_SCHEMA                   			= "en605681";
//  final String		DRIVER                            = "com.mysql.jdbc.Driver";
//  final String		USER                            	= "root";
//  final String		OPTIONS                        		= "?serverTimezone=UTC&useSSL=false";
	
    final String		URL                            		= "jdbc:mysql://web7.jhuep.com:3306/";
    final String		DB_SCHEMA                   			= "class";
    final String		DRIVER                            = "com.mysql.jdbc.Driver";
    final String		USER                            	= "johncolter";
    final String		PASSWD                            = "LetMeIn!";
    final String		OPTIONS                        		= "?serverTimezone=UTC&useSSL=false";
    
    final String		QUERY															= "SELECT reservation.idreservation, reservation.First, reservation.Last, \r\n" + 
    																										"reservation.StartDay, reservation.NumberOfDays, \r\n" +
																								    		"guides.First, guides.Last, locations.location \r\n" + 
																								    		"FROM reservation, guides, locations \r\n" + 
																								    		"WHERE reservation.guide = guides.idguides \r\n" + 
																								    		"AND reservation.location = locations.idlocations;";
}
