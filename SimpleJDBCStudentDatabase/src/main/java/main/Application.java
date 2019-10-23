package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import data.Student;

public class Application {
	private static StudentRepository studentRepository;

	public static void main(String[] args) {
		
		JFrame window = new JFrame("Students JDBC Example");
			window.setBounds(400, 100, 300, 400);
			window.getContentPane().setLayout(new GridLayout(5, 1));
			
		JButton btn_save = new JButton("SAVE");
		JTextField txt_fullname = new JTextField("");
		JTextField txt_dob = new JTextField("");
		JTextField txt_mark = new JTextField("");
		JButton btn_install = new JButton("INSTALL");
			window.getContentPane().add(btn_install);
			window.getContentPane().add(txt_fullname);
			window.getContentPane().add(txt_dob);
			window.getContentPane().add(txt_mark);
			window.getContentPane().add(btn_save);
			
			
			btn_save.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Student s = new Student(txt_fullname.getText(),
												new SimpleDateFormat("dd-mm-yyyy").parse(txt_dob.getText()),
												Float.valueOf(txt_mark.getText())
												
								);
						studentRepository.addStudent(s);
						
						ArrayList<Student> students = studentRepository.all();
						for (Student student : students) System.out.println(student);
						
					} catch (NumberFormatException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					System.out.println("OK!!!!");
					
				}
			});
			
			window.addWindowListener(new WindowAdapter() {
				public void windowOpened(WindowEvent windowEvent) {
					super.windowOpened(windowEvent);
					System.out.println("Opened");
					studentRepository = new StudentRepository();
				}
				
				public void windowClosing(WindowEvent windowEvent) {
					try {
						studentRepository.finalize();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					System.exit(0);
				}
			});
			
			btn_install.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Install");
					studentRepository.install();
				}
			});
		
			window.show();
			
			
			
			
			
			
//		StudentRepository studentRepository = new StudentRepository();
//		
//		//studentRepository.install();
//		
//		Student student = new StudentProvider().provideOneStudent();
//		studentRepository.addStudent(student);
//		
//		int q = 3;
//		ArrayList<Student> students = new StudentProvider().provideManyStudents(q);
//		for(int i = 0; i < q; i++) {
//			try {
//				students = studentRepository.all();
//				
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println(students.size());
//		
//		try {
//			studentRepository.finalize();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
		

	}

}
