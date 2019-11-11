package com.msanti16.servlet.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.msanti16.servlet.constants.DBConnectionConstants;
import com.msanti16.servlet.domain.Reservation;
import com.msanti16.servlet.exceptions.BadIntegerParsingException;
import com.msanti16.servlet.exceptions.BadUserNameException;

public class MyDBConnection {

	public static ArrayList<Reservation> initConnection(String query) 
			throws SQLException, NumberFormatException, BadUserNameException, BadIntegerParsingException {
		String dbUrl = DBConnectionConstants.URL + DBConnectionConstants.DB_SCHEMA + DBConnectionConstants.OPTIONS;
		System.out.println("DB url: " + dbUrl);		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection conn = DriverManager.getConnection(
				dbUrl, DBConnectionConstants.USER, DBConnectionConstants.PASSWD );

		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(query);		
		ArrayList<Reservation> reservationList = new ArrayList<Reservation>();

		if(resultSet.next() == false) {
			System.out.println("Found Nothing!");
		}else {
			System.out.println("Found data!");
			do {
				reservationList.add(new Reservation(
						resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), 
						resultSet.getString(4), resultSet.getString(5), 
						new String(resultSet.getString(6) + " " + resultSet.getString(7)), 
						resultSet.getString(8) 
						));
			} while(resultSet.next());
		}
		
		return reservationList;
	}
	
}
