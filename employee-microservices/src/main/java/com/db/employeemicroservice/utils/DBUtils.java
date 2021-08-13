package com.db.employeemicroservice.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	
	public static void main(String[] args) {
		Connection connection = getConnection();
		System.out.println(connection!=null);
		
	}
	
	public static Connection getConnection() {
		System.out.println(loadProperties());
		Properties properties = loadProperties();
		Connection connection = null;
		
		try{
			Class.forName(properties.getProperty("db.className"));
			connection=DriverManager.getConnection(properties.getProperty("db.url"),properties.getProperty("db.username"),properties.getProperty("db.password"));
			return connection;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public static void closeConnection(Connection connection) {
		
	}
	
	private static Properties loadProperties() {
		
		Properties properties = new Properties();
		
		try(InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("application.properties")){
			properties.load(inputStream);
			return properties;
		}
		catch(IOException e) {
			return null;
			
		}
	}
}
