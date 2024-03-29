package com.springworkspace.demo.rest;

import com.springworkspace.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


	private List<Student> theStudents;

	// define @PostConstruct to load the student data ... only once!
	@PostConstruct
	public void loadData() {

		theStudents = new ArrayList<>();

		theStudents.add(new Student("mete", "yakar"));
		theStudents.add(new Student("ahmet", "yakar"));
		theStudents.add(new Student("beyza", "yakar"));
	}

	// define endpoint for "/students" - return a list of students

	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}


	// define endpoint or "/students/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId)
	{
		// just index into the list ... keep it simple for now

		// check the studentId again list size

		if((studentId >= theStudents.size()) || (studentId < 0))
			throw new StudentNotFoundException("Student id not Found - " + studentId);

		return theStudents.get(studentId);
	}


}
