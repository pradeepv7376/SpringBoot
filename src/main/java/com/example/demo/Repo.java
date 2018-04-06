package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class Repo {
	
	
	public phone AddExcel(phone ph) throws IOException {
		
	
		String[] columns = {"Name", "phone","id" };
	
		  phone employees =  new phone(ph.getPhonenumber(), ph.getName());
		  
		 
             
		        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		   

		        // Create a Sheet
		        Sheet sheet = workbook.createSheet("Employee");

		        // Create a Font for styling header cells
		        Font headerFont = workbook.createFont();
		        headerFont.setBold(true);
		        headerFont.setFontHeightInPoints((short) 14);
		        headerFont.setColor(IndexedColors.RED.getIndex());

		        // Create a CellStyle with the font
		        CellStyle headerCellStyle = workbook.createCellStyle();
		        headerCellStyle.setFont(headerFont);

		        // Create a Row
		        Row headerRow = sheet.createRow(0);

		        // Creating cells
		  
				for(int i = 0; i < columns.length; i++) {
		            Cell cell = headerRow.createCell(i);
		            cell.setCellValue(columns[i]);
		            cell.setCellStyle(headerCellStyle);
				}

		        // Create Other rows and cells with employees data
		        int rowNum = 1;
		  
		            Row row = sheet.createRow(rowNum++);

		            row.createCell(0)
		                    .setCellValue(employees.getName());

		            row.createCell(1)
		                    .setCellValue(employees.getPhonenumber());

				// Resize all columns to fit the content size
		        for(int i = 0; i < columns.length; i++) {
		            sheet.autoSizeColumn(i);
		        }

		        // Write the output to a file
		        FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xlsx");
		        workbook.write(fileOut);
		        fileOut.close();

		        // Closing the workbook
		        workbook.close();
				return employees;
		    }
		
}


