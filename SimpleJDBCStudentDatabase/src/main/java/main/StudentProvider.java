package main;

import data.Student;

import java.util.ArrayList;
import java.util.Locale;

import com.github.javafaker.Faker;

public class StudentProvider {
	
	public Student provideOneStudent() {
		Student student = new Student();
		Faker faker = new Faker(new Locale("ru"));
		student.setFullname(faker.name().fullName());
		student.setDob(faker.date().birthday());
		float mark = faker.number().numberBetween(1, 5);
		student.setMark(mark);
		return student;
		
	}
	
	public ArrayList provideManyStudents(int quantity) {
		ArrayList<Student> students = new ArrayList<>();
		Student student = new Student();
		
		for(int i = 0; i < quantity; i++) {
			student =  provideOneStudent();
			students.add(student);
		}
		
		return students;
		
	}

}
