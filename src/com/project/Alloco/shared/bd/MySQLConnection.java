package com.project.Alloco.shared.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.project.Alloco.shared.Enumerations;

public final class MySQLConnection {
	private static MySQLConnection instance;
	
	private static Connection connection = null;
	
	private MySQLConnection() throws Exception {
		initConnection();
	}

	private void initConnection() throws Exception{
		System.out.println("[TRACE] MySQLConnection: initConnection()");

		try {
            Class.forName(Enumerations.DB_DRIVER);
        } catch (ClassNotFoundException e) {
        	System.out.println("[EXCEPTION] MySQLConnection: initConnection() Class.forName(): Exception");
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }
    	
        connection = null;
        try {
            connection = DriverManager.getConnection(Enumerations.DB_URL, Enumerations.DB_USERNAME, Enumerations.DB_PASSWORD);
        } catch (SQLException e) {
        	System.out.println("[EXCEPTION] MySQLConnection: initConnection() connection: Exception");
            throw new RuntimeException("Cannot connect the database!", e);
        }
	}
	
	public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            	System.out.println("[EXCEPTION] MySQLConnection: closeConnection(): Exception");
               
            }
        }
    }
	
	
	public synchronized static MySQLConnection getInstance()
			throws Exception {
		if (instance == null) {
			
			instance = new MySQLConnection();
		}
		return instance;
	}

	public Connection getConnection() {
		
	    try {
	    	if (connection != null) {
	    		if (connection.isClosed() || !connection.isValid(10000)) {
	    			
	            	this.initConnection();
	            }
	    	} else {
	    		this.initConnection();
	        }
	    } catch (Exception e) {
	    	System.out.println("[EXCEPTION] MySQLConnection: getConnection(): Exception");
	    	
	    }
	    return connection;
	}
}
