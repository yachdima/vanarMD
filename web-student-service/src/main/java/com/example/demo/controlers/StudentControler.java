package com.example.demo.controlers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControler {
	
	@RequestMapping(value="/students")
	public List<String> getStudents(@RequestParam(required = false) String word){
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("John Trevolta");
		list.add("Mary Cay");
		list.add("Irina Tobin");
		
		// http://localhost:8080/students?word=Jo
		return list
				.stream()
				.filter(name -> word != null && word !="" ? name.contains(word):true)
				.collect(Collectors.toList());
	}
	
	// http://localhost:8080/students/create?name=Ivan
	@PostMapping(value="/students/create")
	public String createStudent(@RequestParam String name) {
		String student_name = name;
		System.err.println(student_name);
		return student_name;
	}
}
