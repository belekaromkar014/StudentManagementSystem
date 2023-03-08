package com.project.StrudentManagementSystem.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.StrudentManagementSystem.dao.StudentDao;
import com.project.StrudentManagementSystem.entity.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao studentDao;
	
	public void insertData(Student student) {
		studentDao.insertData(student);
	}
	
	public List<Student> getData() {
		List<Student> students = studentDao.getData();
		return students;
	}
	
	public void updateData(Student student) {
		studentDao.updateData(student);
	}
	
	public Student getSpecificData(int id) {
		Student student = studentDao.getSpecificData(id);
		return student;
	}
	
	public void deleteData(int id) {
		studentDao.deleteData(id);
	}
}
