package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {
	protected static Connection connection;
	protected static String database_url = "jdbc:postgresql://localhost:5432/university_app";
	protected static Statement statement;
	
	public static void main(String[] args) {
		try {
			connection = DriverManager.getConnection(database_url,"postgres", "dk5gh");
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		install();
		addStudent();
		

	}
	
	
	public static boolean install() {
		
		try {
			statement.executeUpdate("drop table if exists Students");
			statement.executeUpdate("create table if not exists Students(\r\n" + 
				 		"	ID Serial primary key,\r\n" + 
				 		"	fullname varchar(30),\r\n" + 
				 		"	dob date,\r\n" + 
				 		"	mark numeric\r\n" + 
				 		"); ");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public static boolean addStudent() {
		try {
			String mark = "5.5";
			String query = "INSERT INTO students(fullname,dob,mark) VALUES('st1', '2019-05-01', "+mark+");";
			System.out.println(query);
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

}
