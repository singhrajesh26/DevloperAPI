package com.test.misExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CollectAllTheLinksAndClickLinks {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		WebDriver driver;
		driver = new EdgeDriver();
		driver.navigate().to("https://developer.mastercard.com/account/log-in");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			try {
				List<WebElement> linkToClick=driver.findElements(By.xpath("//a[@id='caseStudies' or @id='partnerPrograms' or starts-with(@id,'navPrimary')]"));
				
				 //TagName[@Att1='Value' or starts-with(@Att2,'Starting Value')]
				//List<WebElement> linkToClick=driver.findElements(By.cssSelector("a[id*='navPrimary']"));
				//linkToClick.click();
				
				
				String  pageLoadStatus;
				for(WebElement link:linkToClick){
				
					String nameLinks = link.getText();
					System.out.println(nameLinks);
				Thread.sleep(3000);
				  link.click();
				do {

					JavascriptExecutor js = (JavascriptExecutor) driver;

					pageLoadStatus = (String)js.executeScript("return document.readyState");

					} while ( !pageLoadStatus.equals("complete") );
				
				} System.out.println( " Page is loaded.");
				
			} catch (Exception e) {
				System.out.println( " Page is not loaded "+ e);
			}
			
			driver.close();
	}
		

	}


