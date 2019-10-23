package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import data.Student;

public class Application {

	public static void main(String[] args) {
		
		StudentRepository studentRepository = new StudentRepository();
		
		//studentRepository.install();
		
		Student student = new StudentProvider().provideOneStudent();
		studentRepository.addStudent(student);
		
		int q = 3;
		ArrayList<Student> students = new StudentProvider().provideManyStudents(q);
		for(int i = 0; i < q; i++) {
			try {
				students = studentRepository.all();
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		System.out.println(students.size());
		
		try {
			studentRepository.finalize();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
