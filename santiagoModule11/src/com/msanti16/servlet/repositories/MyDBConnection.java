package com.msanti16.servlet.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DatabaseMetaData;

import com.msanti16.servlet.constants.DBConnectionConstants;
import com.msanti16.servlet.domain.Reservation;
import com.msanti16.servlet.exceptions.BadIntegerParsingException;
import com.msanti16.servlet.exceptions.BadUserNameException;

public class MyDBConnection {

	public static ArrayList<Reservation>  initConnection(String query) 
			throws SQLException, NumberFormatException, BadUserNameException, BadIntegerParsingException {
		String dbUrl = DBConnectionConstants.URL + DBConnectionConstants.DB_SCHEMA + DBConnectionConstants.OPTIONS;
		System.out.println("dbUrl: " + dbUrl);		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection conn = DriverManager.getConnection(
				dbUrl, DBConnectionConstants.USER, DBConnectionConstants.PASSWD );
		
		
		DatabaseMetaData metadata = conn.getMetaData();
		System.out.println("Driver: " + metadata.getDriverName());
		System.out.println("Driver version: " + metadata.getDriverVersion());
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
		resultSet.first();
		while(!resultSet.isAfterLast()) {
			System.out.print("- ");
			reservationList.add(new Reservation(
					resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), 
					resultSet.getString(4), resultSet.getString(5), 
					new String(resultSet.getString(6) + resultSet.getString(7)), resultSet.getString(8) 
					));
			System.out.print(resultSet.getString(1));
			System.out.print(", " + resultSet.getString(2));
			System.out.print(", " + resultSet.getString(3));
			System.out.print(", " + resultSet.getString(4));
			System.out.print(", " + resultSet.getString(5));
			System.out.print(", " + resultSet.getString(6));
			System.out.print(", " + resultSet.getString(7));
			System.out.print(", " + resultSet.getString(8));
			System.out.println(" ");
			resultSet.next();
		}
		
		return reservationList;
	}
	
	public void closeConnection() throws SQLException {
		
	}
	
}
