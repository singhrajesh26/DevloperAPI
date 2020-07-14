package com.test.jbehave.pages;

/**
 * Created with Eclipse. User: Rajesh Date: 14.07.20 Time: 20:00 To change this
 * use to launch base url of the application under test
 */

import com.test.jbehave.main.Driver;
import com.test.jbehave.main.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends Page{

    @FindBy (xpath = "//*[@id='homeIntroLoginLink']/div")
    WebElement button;

    public void open(String url) {
        Driver.driver.get(url);
    }

    public ServiceLogin clickLoginButton() {
        button.click();
        return new ServiceLogin();
    }

}
