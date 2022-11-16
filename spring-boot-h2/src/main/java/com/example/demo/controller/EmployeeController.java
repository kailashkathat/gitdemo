package com.example.demo.controller;

import java.util.List;

import javax.annotation.Generated;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;

@RestController
public class EmployeeController {
@Autowired
private EmployeeRepository empRepository;
@PostMapping("/saveEmployee")

public String saveEmployee(@RequestBody Employee employee)
{  try
{   System.out.println("inside try2");
	empRepository.save(employee);
	
}
catch(Exception e)
{  System.out.println("catch");
	e.printStackTrace();
	System.out.println("message"+e.getMessage());
}
return "Employee Saved";
}

@GetMapping("/getAllEmployees")
public List<Employee> getAll()
{  System.out.println("getall");
	try
	{
	return empRepository.findAll();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("e"+e.getMessage());
	}
	return empRepository.findAll();
}

@GetMapping("/getEmployee/{dept}")	
public List<Employee> getEmployeesByDept(@PathVariable String dept)
{
	return empRepository.findById(dept);
}

}
