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

public class SecondMethodCollectAllTheLinksAndClickLinks {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		WebDriver driver;
		driver = new EdgeDriver();
		driver.navigate().to("https://developer.mastercard.com/account/log-in");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
				List<WebElement> linkElements=driver.findElements(By.xpath("//a[@id='caseStudies' or @id='partnerPrograms' or starts-with(@id,'navPrimary')]"));
				
				String[] linkTexts = new String[linkElements.size()];
				int	i = 0;
				
				for (WebElement e : linkElements) {							
					linkTexts[i] = e.getText();							
					i++;			
		        }	
				
				for (String t : linkTexts) {
					Thread.sleep(3000);
					driver.findElement(By.linkText(t)).click();
					System.out.println("\"" + t + "\""								
	                        + " is working.");
					
				
	}
				driver.quit();	
	}
	

}


