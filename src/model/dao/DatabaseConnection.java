package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
		
	public static Connection connection;
	public static boolean isConnected;
	
	public static Connection getConnection()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:database/database.db";  
		        
			try {
				connection = DriverManager.getConnection(url);
				isConnected = true;
			} catch (SQLException erro) {
				isConnected = false;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Nao conectou drive");
		}
		
		return connection;
	}
	
	public static void main(String[] args){
		DatabaseConnection.getConnection();
	}
}
