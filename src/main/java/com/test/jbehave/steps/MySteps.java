package com.test.jbehave.steps;

/**
 * Created with Eclipse. User: Rajesh Date: 14.07.20 Time: 20:00 To change this
 * This is step file which is associated with JBehave Story file and all the required methods are called to executed the required JBehave Story file steps
 */

import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.jbehave.core.annotations.Named;
import com.test.jbehave.main.Base;
import com.test.jbehave.main.Driver;
import com.test.jbehave.pages.HomePage;
import com.test.jbehave.pages.ServiceLogin;

public class MySteps extends Base {

	private HomePage homePage;
	private ServiceLogin serviceLogin;	
	private Map<String, String> link;


	
	
	
	 @Given("home mc page $url")
		public void givenMasterCardBasePage(String url) {
			homePage = new HomePage();
			homePage.open(url);
		}

		@When("use click on menu link")
		public void windowhandle() throws InterruptedException {
			
			  checkIfPageIsLoaded("Solutions"); checkIfPageIsLoaded("APIs");
			  checkIfPageIsLoaded("New & Experimental");
			  checkIfPageIsLoaded("Partner Programs"); checkIfPageIsLoaded("Case Studies");
			  checkIfPageIsLoaded("Blog"); checkIfPageIsLoaded("Support");
			  checkIfPageIsLoaded("Search"); checkIfPageIsLoaded("Sign Up");
			  checkIfPageIsLoaded("Log In");
			 
			
			
		}
		
		@Then("user able to validate page is loaded")
		public void checkIfPageIsLoaded(String link) throws InterruptedException
		{
			
			Thread.sleep(1000);
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
				    
		/*
		 * @Then("user able to validate page is loaded: $examplesTable") public void
		 * validateLink(ExamplesTable examplesTable) { link = examplesTable.getRow(0);
		 * try { WebElement
		 * linkToClick=Driver.driver.findElement(By.xpath("//a[text()='"+link+"']"));
		 * linkToClick.click(); String pageLoadStatus; do {
		 * 
		 * JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
		 * 
		 * pageLoadStatus = (String)js.executeScript("return document.readyState");
		 * 
		 * } while ( !pageLoadStatus.equals("complete") );
		 * 
		 * System.out.println(link+ " Page is loaded.");
		 * 
		 * } catch (Exception e) { System.out.println(link+ " Page is not loaded "+ e);
		 * }
		 * 
		 * }
		 */

		@Then("user able to validate if $page is loaded") 
		public void validateLink(@Named("page") String page) {
			
			try {
				WebElement linkToClick=Driver.driver.findElement(By.xpath("//a[text()='"+page+"']"));
				linkToClick.click();
				String  pageLoadStatus;
				do {

					JavascriptExecutor js = (JavascriptExecutor) Driver.driver;

					pageLoadStatus = (String)js.executeScript("return document.readyState");

					} while ( !pageLoadStatus.equals("complete") );
				
				System.out.println(page+ " Page is loaded.");
				
			} catch (Exception e) {
				System.out.println(page+ " Page is not loaded "+ e);
			}
			
			
		}
		
}