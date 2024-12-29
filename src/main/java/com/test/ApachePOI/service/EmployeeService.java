package com.test.ApachePOI.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.hibernate.boot.model.source.internal.hbm.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.ApachePOI.entity.Employee;
import com.test.ApachePOI.helper.EmployeeHelper;
import com.test.ApachePOI.repo.EmployeeRepo;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
 public void save (MultipartFile file)// we give this method our excel file and it convert excel file data to employee data and then save in java. 
 {
	 try {
		 List<Employee> employees=EmployeeHelper.convertExcelToListOfEmployee(file.getInputStream());	
	    this.employeeRepo.saveAll(employees);
	 } catch (IOException e) {
		e.printStackTrace();
	}
 }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
 
 
 
public List<Employee> getAllEmployees(){
	return this.employeeRepo.findAll();
	
}
}
