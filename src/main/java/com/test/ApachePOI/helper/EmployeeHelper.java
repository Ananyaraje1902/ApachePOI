package com.test.ApachePOI.helper;

import java.io.File;
import java.io.InputStream;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy.FirstCharBasedValidator;
import com.test.ApachePOI.entity.Employee;

import jakarta.persistence.Convert;
import jakarta.persistence.criteria.CriteriaBuilder.Case;

public class EmployeeHelper {
	       
		public static boolean checkExcelFormat(MultipartFile file) {
			String contentType = file.getContentType();
			if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
				return true;
			} 
			else {
				 return false;
			} 
		}
		
			// convert excel to list of employee	
			public static List<Employee> convertExcelToListOfEmployee(InputStream is){
				List<Employee> list = new ArrayList<>();
				try {
					XSSFWorkbook workbook=new XSSFWorkbook(is);
					
				
				XSSFSheet sheet=workbook.getSheet("data");
				int rowNumber =0; //first from zero row 
				Iterator<Row> iterator=sheet.iterator();
				while(iterator.hasNext()) {
					Row row=iterator.next();
					if(rowNumber==0) {
						rowNumber++;
						continue;
						
					}
					int cellNum=0;
					Employee emp=new Employee();
					Iterator<Cell> iterator2=row
							.iterator();
					while(iterator2.hasNext()) {
						Cell cell=iterator2.next();
						switch (cellNum) {
						case 0:
						     emp.setId((int)cell.getNumericCellValue());// READ DATA OF ID 1 AND SET TO EMP ID.
						     break;
						case 1:
							emp.setEname(cell.getStringCellValue());
							break;
						case 2:
							emp.setProfile(cell.getStringCellValue());
							break;
						case 3:
							emp.setScore(cell.getNumericCellValue());
							break;
						default:
							break;
						}
						cellNum++;
						list.add(emp);
						
					}
				}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			     }
		
	

		}

