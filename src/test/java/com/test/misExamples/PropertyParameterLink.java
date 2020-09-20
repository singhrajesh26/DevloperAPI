package com.test.misExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class PropertyParameterLink {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		WebDriver driver;
		 driver = new EdgeDriver();
		driver.navigate().to("https://developer.mastercard.com/account/log-in");
	//	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Properties properties = new Properties();
		FileInputStream propFile;
		try {
			propFile = new FileInputStream("C:\\Projects_Repo\\jbehave-selenium-master\\link.properties");
			properties.load(propFile);
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		
		@SuppressWarnings("unchecked")
		Enumeration<String> e = (Enumeration<String>) properties.propertyNames();
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			System.setProperty(key, properties.getProperty(key));
			
		//} 
		
		String lnk = System.getProperty("link.test");
		try {
			
			
			WebElement linkToClick=driver.findElement(By.xpath("//a[text()='"+lnk+"']"));
			linkToClick.click();
			
			System.out.println(System.getProperty("link.test"));
			String  pageLoadStatus;
			
			
			do {

				JavascriptExecutor js = (JavascriptExecutor) driver;

				pageLoadStatus = (String)js.executeScript("return document.readyState");

				} while ( !pageLoadStatus.equals("complete") );
			
			System.out.println(lnk+ " Page is loaded.");
			
		} catch (Exception ex) {
			System.out.println(lnk+ " Page is not loaded "+ e);
		}

	}
		
		driver.close();
		
	}
	

}
