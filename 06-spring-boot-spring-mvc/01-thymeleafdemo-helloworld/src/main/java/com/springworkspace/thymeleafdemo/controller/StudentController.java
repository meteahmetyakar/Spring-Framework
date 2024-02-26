package com.springworkspace.thymeleafdemo.controller;

import com.springworkspace.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

	@Value("${countries}")
	private List<String> countries;

	@GetMapping("/showStudentForm")
	public String showForm(Model theModel)
	{

		Student theStudent = new Student();

		theModel.addAttribute("student", theStudent);
		theModel.addAttribute("countries", countries);
		return "student-form";
	}

	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student theStudent)
	{

		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

		return "student-confirmation";
	}

}