package com.test.ApachePOI.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.ApachePOI.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
