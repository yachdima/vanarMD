package entities;

import java.util.ArrayList;
import java.util.Locale;

import com.github.javafaker.Faker;

public class StudentProvider {
	
	public static Student provideOneStudent() {
		Student student = new Student();
		Faker faker = new Faker(new Locale("ru"));
		student.setFullName("TEST "+faker.name().fullName());
		student.setDob(faker.date().birthday());
		float mark = faker.number().numberBetween(1, 5);
		student.setMark(mark);
		Performance per = new Performance(5.5f,40,50,Performance.Behaviour.GOOD);
		student.setPerformance(per);
		return student;
		
	}
	
	public static JMHJoinStudent provideOneStudentJoin() {
		JMHJoinStudent student = new JMHJoinStudent();
		Faker faker = new Faker(new Locale("ru"));
		student.setFullName("TEST "+faker.name().fullName());
		student.setDob(faker.date().birthday());
		float mark = faker.number().numberBetween(1, 5);
		student.setMark(mark);
		Performance per = new Performance(5.5f,40,50,Performance.Behaviour.GOOD);
		student.setPerformance(per);
		return student;
		
	}

}
