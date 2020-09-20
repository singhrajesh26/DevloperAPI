package com.test.misExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MastercardDevClass {

	WebDriver driver;

	@Test
	public void windowhandle() {
		checkIfPageIsLoaded("Solutions");
		checkIfPageIsLoaded("APIs");
		checkIfPageIsLoaded("New & Experimental");
		checkIfPageIsLoaded("Partner Programs");
		checkIfPageIsLoaded("Case Studies");
		checkIfPageIsLoaded("Blog");
		checkIfPageIsLoaded("Support");
		checkIfPageIsLoaded("Search");
		checkIfPageIsLoaded("Sign Up");
		checkIfPageIsLoaded("Log In");
		
		
	}
	
	public void checkIfPageIsLoaded(String link)
	{
		try {
			WebElement linkToClick=driver.findElement(By.xpath("//a[text()='"+link+"']"));
			linkToClick.click();
			String  pageLoadStatus;
			
			
			do {

				JavascriptExecutor js = (JavascriptExecutor) driver;

				pageLoadStatus = (String)js.executeScript("return document.readyState");

				} while ( !pageLoadStatus.equals("complete") );
			
			System.out.println(link+ " Page is loaded.");
			
		} catch (Exception e) {
			System.out.println(link+ " Page is not loaded "+ e);
		}
		
	}

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		 driver = new EdgeDriver();
		driver.navigate().to("https://developer.mastercard.com/account/log-in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void teardown() {

		driver.quit();
	}

}