package com.test.jbehave.main;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;

/**
 * Created with Eclipse. User: Rajesh Date: 14.07.20 Time: 20:00 To change this
 * use to launch Web driver instance and closing the instance
 */

public class Base {
	@BeforeScenario
	public void initialization() {
		Driver.init();
		Driver.driver.manage().window().maximize();
		Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Driver.driver.manage().setSpeed(Speed.SLOW);
	}

	
	  @AfterScenario 
	  public void cleanup() 
	  {
		  Driver.tearDown();
	   }
	 
}
