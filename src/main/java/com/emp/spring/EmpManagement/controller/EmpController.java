package com.emp.spring.EmpManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.spring.EmpManagement.entity.Employee;
import com.emp.spring.EmpManagement.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee> emp=service.getAllEmployee();
		m.addAttribute("emp",emp);
		return "index";
	}
	@GetMapping("/reg")
	public String emp_register()
	{
		return "reg";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute Employee e)
	{
		service.addEmp(e);
		//session.setAttribute("msg", "user added successfully..");
		return "index";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		Employee e=service.getById(id);
		m.addAttribute("emp",e);
		return "edit";
	}

}
