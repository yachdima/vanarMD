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

import data.Group;
import data.Student;

public class Application {
	private static StudentRepository studentRepository;
	private static GroupRepository groupRepository;

	public static void main(String[] args) {
		
		JFrame window_main = new JFrame("Students JDBC Example");
		window_main.setBounds(400, 100, 100, 100);
		window_main.getContentPane().setLayout(new GridLayout(2, 1));
		JButton btn_student = new JButton("STUDENT");
		JButton btn_group = new JButton("GROUP");
		window_main.getContentPane().add(btn_student);
		window_main.getContentPane().add(btn_group);
		window_main.show();
		
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
			
			btn_student.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Student");
					window.show();
				}
			});
		
			//---------------------------
			
			JFrame window_g = new JFrame("Groups JDBC Example");
			window_g.setBounds(400, 100, 300, 400);
			window_g.getContentPane().setLayout(new GridLayout(4, 1));
			
		JButton btn_save_g = new JButton("SAVE");
		JTextField txt_name_g = new JTextField("");
		JTextField txt_code_g = new JTextField("");
		JButton btn_install_g = new JButton("INSTALL");
		
		window_g.getContentPane().add(btn_install_g);
		window_g.getContentPane().add(txt_name_g);
		window_g.getContentPane().add(txt_code_g);
		window_g.getContentPane().add(btn_save_g);
			
			
			btn_save_g.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Group g = new Group(txt_name_g.getText(),
											txt_code_g.getText()
												
								);
						groupRepository.addGroup(g);
						
						ArrayList<Group> groups = groupRepository.all();
						for (Group group : groups) System.out.println(group);
						
					} catch (NumberFormatException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					System.out.println("OK!!!!");
					
				}
			});
			
			window_g.addWindowListener(new WindowAdapter() {
				public void windowOpened(WindowEvent windowEvent) {
					super.windowOpened(windowEvent);
					System.out.println("Opened");
					groupRepository = new GroupRepository();
				}
				
				public void windowClosing(WindowEvent windowEvent) {
					try {
						groupRepository.finalize();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					System.exit(0);
				}
			});
			
	
			
			btn_group.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Group");
					window_g.show();
				}
			});
			
			btn_install_g.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Install");
					groupRepository.install();
				}
			});
			
			
			
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
