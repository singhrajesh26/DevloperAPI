package com.test.misExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ReadPropertyFile {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		WebDriver driver;
		driver = new EdgeDriver();
		driver.navigate().to("https://developer.mastercard.com/account/log-in");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {

			File file = new File("C:\\Projects_Repo\\jbehave-selenium-master\\link.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			Enumeration enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key); 
				Thread.sleep(1000); 
				WebElement linkToClick = driver.findElement(By.xpath("//a[text()='" + value + "']"));
				linkToClick.click(); 
				String pageLoadStatus; 
				do { 
					JavascriptExecutor js = (JavascriptExecutor) driver; 
					pageLoadStatus = (String) js.executeScript("return document.readyState"); 
				} while (!pageLoadStatus.equals("complete")); 
				System.out.println(value + " Page is loaded."); 
			} 
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.close();

	}

}
