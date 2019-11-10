package com.msanti16.servlet.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.msanti16.servlet.constants.DBConnectionConstants;

public abstract class MyDBConnection {

	public void initConnection(String query) throws SQLException {
		Connection 			conn;
		Statement 			statement;
		ResultSet 			resultSet;
		conn = DriverManager.getConnection(
				DBConnectionConstants.URL + DBConnectionConstants.DB +
				DBConnectionConstants.OPTIONS, DBConnectionConstants.USER,
				DBConnectionConstants.PASSWD );
		
		resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			System.out.println("1:" + resultSet.getString(1));
			System.out.println("2:" + resultSet.getString(2));
			System.out.println("3:" + resultSet.getString(3));
		}
		
		this.resultSet.close();
	}
	
	public void closeConnection() throws SQLException {
		
	}
	
}
