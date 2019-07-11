package com.app.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWrite {
public static void main(String[] args) throws Exception {
	String testDataPath="./src/test/resources/testData/DataTable1.xlsx";//insetad of project name we add "."

	FileInputStream inStream=new FileInputStream(testDataPath);
	Workbook workbook=WorkbookFactory.create(inStream);
	Sheet worksheet=workbook.getSheet("Sheet1"); //this I use the name of the sheet. in read, I used index number=0;
	
	//I find his job
	Cell job= worksheet.getRow(6).getCell(2);
	//I change his job
	job.setCellValue("Architecture Engineer");
	//I am saving it
	FileOutputStream outStream=new FileOutputStream(testDataPath);
	workbook.write(outStream);
	outStream.close();
	workbook.close();
	inStream.close();//these steo are only changing the Eclipse mod not my desktop excell file





}
}
