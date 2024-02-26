package com.springworkspace.cruddemo.dao;

import com.springworkspace.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

	List<Employee> findAll();

	Employee findById(int theId);

	Employee save(Employee theEmployee);

	void delete(int theId);

}
