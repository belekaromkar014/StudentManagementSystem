package com.project.StrudentManagementSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="student")
public class Student {
	@Id
	int id;
	String name;
	int rollnum;
	int age;
	String std;
	
	public Student(int id, String name, int rollnum, int age, String std) {
		super();
		this.id = id;
		this.name = name;
		this.rollnum = rollnum;
		this.age = age;
		this.std = std;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollnum() {
		return rollnum;
	}

	public void setRollnum(int rollnum) {
		this.rollnum = rollnum;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rollnum=" + rollnum + ", age=" + age + ", std=" + std + "]";
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	


}
