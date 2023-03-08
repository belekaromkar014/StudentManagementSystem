package com.project.StrudentManagementSystem.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.StrudentManagementSystem.entity.Student;
import com.project.StrudentManagementSystem.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("insertstudent")
	public String insertData(@RequestBody Student student) {
		studentService.insertData(student);
		return "Record Added";
	}
	
	@GetMapping("getstudent")
	public List<Student> getData() {
		List<Student> students = studentService.getData();
		return students;
	}
	
	@PutMapping("updatedata")
	public String updateData(@RequestBody Student student) {
		studentService.updateData(student);
		return "Record Updated";
	}
	
	@GetMapping("getspecificdata/{id}")
	public Student getSpecificData(@PathVariable int id) {
		Student student = studentService.getSpecificData(id);
		return student;
	}
	
	@DeleteMapping("deletedata/{id}")
	public String deleteData(@PathVariable int id) {
		studentService.deleteData(id);
		return "Record Deleted";
	}

}
