package com.springworkspace.cruddemo.dao;

import com.springworkspace.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {



}
