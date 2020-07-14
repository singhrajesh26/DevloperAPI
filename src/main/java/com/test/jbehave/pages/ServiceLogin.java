package com.test.jbehave.pages;

import com.test.jbehave.main.Driver;

/**
 * Created with Eclipse. User: Rajesh Date: 14.07.20 Time: 20:00 To change this
 * Creating Object Repo and associated with unique Method
 */

import com.test.jbehave.main.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceLogin extends Page {  	

	
	
	@FindBy(xpath = "//button[@data-uid='request-submitted-okay-button']")
	WebElement closeSucessButton;

	
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
			WebElement linkToClick=Driver.driver.findElement(By.xpath("//a[text()='"+link+"']"));
			linkToClick.click();
			String  pageLoadStatus;
			do {

				JavascriptExecutor js = (JavascriptExecutor) Driver.driver;

				pageLoadStatus = (String)js.executeScript("return document.readyState");

				} while ( !pageLoadStatus.equals("complete") );
			
			System.out.println(link+ " Page is loaded.");
			
		} catch (Exception e) {
			System.out.println(link+ " Page is not loaded "+ e);
		}
		
	}	
		

}
