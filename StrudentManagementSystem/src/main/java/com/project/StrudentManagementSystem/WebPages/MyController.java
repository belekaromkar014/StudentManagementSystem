package com.project.StrudentManagementSystem.WebPages;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.StrudentManagementSystem.controller.StudentController;
import com.project.StrudentManagementSystem.entity.Student;

@Controller
public class MyController {
	@Autowired
	StudentController studentController;
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("APIcall")
	public String APIcall() {
		return "APIcall";
	}

	@RequestMapping("test")
	public ModelAndView test() {
		// creating arraylist 
		ArrayList<String> list = new ArrayList<String>();
		list.add("omkar");
		list.add("rupali");
		list.add("rushi");
		list.add("tejas");
		
		List<Student> list2 = studentController.getData();
		
		//test is a view name
		// model means data which will be display on web page test.jsp
		// list is model here
		// data is calles modelandview and list is its value
		
		ModelAndView modelAndView = new ModelAndView("test", "data", list2);
		
		return modelAndView;
	}
}
