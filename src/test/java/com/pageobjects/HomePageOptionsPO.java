package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageOptionsPO {
	public WebDriver driver;

	public HomePageOptionsPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Options inside links
	@FindBy(how = How.PARTIAL_LINK_TEXT , using = "Options")
	public WebElement mainOptions;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "activities")
	public WebElement optionsAllActivitiesLink;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "all users")
	public WebElement optionsAllUsersLink;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "two days")
	public WebElement optionsTwoDaysLink;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "x")
	public WebElement optioncloseLink;
	
}
