package com.createobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPO {
	public WebDriver driver;
	
	public CreateLeadPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	//Create Lead elements
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'lead_first_name']")
	public WebElement leadFirstName;
	@FindBy(how = How.XPATH, using = "//input[@id = 'lead_last_name']")
	public WebElement leadLastName;
	@FindBy(how = How.XPATH, using = "//input[@id = 'lead_email']")
	public WebElement leadEmail;
	@FindBy(how = How.XPATH, using = "//input[@id = 'lead_phone']")
	public WebElement leadPhone;
	@FindBy(how = How.XPATH, using = "//input[@value = 'Create Lead']")
	public WebElement createLeadButton;

}
