package com.test.misExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class ParameterzeLinkWithExcel {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		WebDriver driver;
		 driver = new EdgeDriver();
		driver.navigate().to("https://developer.mastercard.com/account/log-in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/*
		 * File f = new File("C:\\Mis\\Assinment\\LinkName.xlsx");
		 * 
		 * FileInputStream fs = new FileInputStream(f); XSSFWorkbook wb = new
		 * XSSFWorkbook(fs); XSSFSheet sh = wb.getSheetAt(0); int size =
		 * sh.getLastRowNum();
		 */
		
		Workbook wb = WorkbookFactory.create(new File("C:\\Mis\\Assinment\\LinkName.xlsx"));
		Sheet s = wb.getSheetAt(0);
		int rowCount = s.getPhysicalNumberOfRows();
		
		System.out.println("Total rows are " +rowCount);
		
		for(int i=1; i<rowCount; i++) {
			Thread.sleep(1000);
		try {
			WebElement linkToClick=driver.findElement(By.xpath("//a[text()='"+s.getRow(i).getCell(0).getStringCellValue()+"']"));
			linkToClick.click();
			String  pageLoadStatus;
			//System.out.println("List of the Links in Excel  " + s.getRow(i).getCell(0).getStringCellValue());
			
			
			do {

				JavascriptExecutor js = (JavascriptExecutor) driver;

				pageLoadStatus = (String)js.executeScript("return document.readyState");

				} while ( !pageLoadStatus.equals("complete") );
			
			System.out.println(s.getRow(i).getCell(0).getStringCellValue()+ " Page is loaded.");
			
		} catch (Exception e) {
			System.out.println(s.getRow(i).getCell(0).getStringCellValue()+ " Page is not loaded ");
		}

	}
		
		driver.close();
		
	}
	

}
