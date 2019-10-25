package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Repository {
	protected Connection connection;
	protected String database_url = "jdbc:sqlite:university.db";
	protected Statement statement;
	protected SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
	
	public Repository() {
		try {
			connection = DriverManager.getConnection(database_url);
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void finalize() throws SQLException {
		connection.close();
	}
	
	
	
}
