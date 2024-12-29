package com.test.ApachePOI.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.ApachePOI.entity.Employee;
import com.test.ApachePOI.helper.EmployeeHelper;
import com.test.ApachePOI.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {

	
	
	@Autowired
private EmployeeService employeeService;
	@PostMapping("/employee/upload")
	public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file){
		if(EmployeeHelper.checkExcelFormat(file)) {
			this.employeeService.save(file);
			return ResponseEntity.ok(Map.of("message","file is uploaded and data is saved to db"));
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload Excel file");
		
	}
	
   @GetMapping("/employee")
	public List<Employee> getAllEmployees(){
		return this.employeeService.getAllEmployees();
		
	}
}
