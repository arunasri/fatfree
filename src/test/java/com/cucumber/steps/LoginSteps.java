package com.cucumber.steps;

import com.pageobjects.LoginPagePO;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    public Logger logger = Logger.getLogger(this.getClass().getName());
    WebDriver driver;
    String baseUrl;
    @Before
    public void openBrowser() {
        DOMConfigurator.configure("log4j.xml");
        driver = new ChromeDriver();
        baseUrl = "http://qacrm.herokuapp.com/";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }
    @Given("^User is on login page$")
    public void user_is_on_login_page() throws Throwable {
        driver.get(baseUrl);
    }

    @When("^User enters \"(.*?)\" and \"(.*?)\"$")
    public void user_enters_and(String username, String password) throws Throwable {
        LoginPagePO login = new LoginPagePO(driver);
        login.username.sendKeys(username);
        login.password.sendKeys(password);
        logger.info("entering login page");
        login.loginButton.click();
        // Given I am on login page
        logger.info("authenticating as george");
    }

    @Then("^User should land on dash board page$")
    public void user_should_land_on_dash_board_page() throws Throwable {
        Assert.assertEquals(driver.getCurrentUrl(),"http://qacrm.herokuapp.com/" );
    }
    @Then("^User should land on login error page$")
    public void user_should_land_on_login_error_page() throws Throwable {
        Assert.assertEquals(driver.getCurrentUrl(),"http://qacrm.herokuapp.com/login" );
    }
    @After
    public void closeBrower() {
        driver.quit();
    }
}
