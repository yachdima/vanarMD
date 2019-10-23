package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import data.Student;

public class StudentRepository {
	private Connection connection;
	private String database_url = "jdbc:sqlite:university.db";
	Statement statement;
	SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
	
	public StudentRepository() {
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
	
	public boolean install() {
		
		try {
			statement.executeUpdate("drop table students");
			statement.executeUpdate("CREATE TABLE students(\r\n" + 
					"    id INTEGER PRIMARY KEY AUTOINCREMENT, \r\n" + 
					"     fullname VARCHAR(30),\r\n" + 
					"     dob DATE,\r\n" + 
					"     mark DECIMAL(6,2)\r\n" + 
					" ); ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean addStudent(Student student) {
		try {
			String query = "INSERT INTO students VALUES( null, '"+student.getFullname()+"', '"
																+format.format(student.getDob())
																+"', "+student.getMark()+");";
			System.out.println(query);
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public ArrayList all() throws ParseException {
		ArrayList students = new ArrayList<>();
		
		ResultSet r;
		try {
			r = statement.executeQuery("select * from students");
			while (r.next()) {
				Student student = new Student(r.getInt("id"),
										r.getString("fullname"),
										format.parse(r.getString("dob")),
										r.getFloat("mark"));
				students.add(student);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
		
	}
	
	public void update( Student student ) {
		try {
			statement.executeUpdate("UPDATE students SET fullname = "+student.getFullname()+
																", dob = "+student.getDob()+
																", mark = "+student.getMark()+
																" WHERE id = "+student.getId()+";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete( Student student ) {
		try {
			statement.executeUpdate("DELETE FROM students WHERE id = "+student.getId()+";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
