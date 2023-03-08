package com.project.StrudentManagementSystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.StrudentManagementSystem.entity.Student;

@Repository
public class StudentDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertData(@RequestBody Student student) {
		Session session = sessionFactory.openSession();
		session.save(student);
		session.beginTransaction().commit();
	}

	public List<Student> getData() {
		List<Student> students = sessionFactory.openSession().createCriteria(Student.class).list();
		return students;
	}

	public void updateData(Student student) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(student);
		session.beginTransaction().commit();
	}

	public Student getSpecificData(@PathVariable int id) {
		Session session = sessionFactory.openSession();
		Student student = session.get(Student.class, id);
		return student;
	}

	public void deleteData(@PathVariable int id) {
		Session session = sessionFactory.openSession();
		Student student = session.get(Student.class, id);
		session.delete(student);
		session.beginTransaction().commit();
	}

}
