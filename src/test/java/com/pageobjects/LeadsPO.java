package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LeadsPO {
	public WebDriver driver;
	
	public LeadsPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	// Left Pane pending check box lists //
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Lead Statuses')]")
	public WebElement leftPaneCaptionLeadStatuses;
	@FindBy(how = How.XPATH, using = "//div[@class='check_box']//input[@id='new']")
	public WebElement leftpanenewCheckbox;
	@FindBy(how = How.XPATH, using = "//div[@class='check_box']//input[@id='contacted']")
	public WebElement leftPaneContactedCheckbox;
	@FindBy(how = How.XPATH, using = "//div[@class='check_box']//input[@id='converted']")
	public WebElement leftPaneConvertedCheckbox;
	@FindBy(how = How.XPATH, using = "//div[@class='check_box']//input[@id='rejected']")
	public WebElement leftPaneRejectedCheckbox;
	@FindBy(how = How.XPATH, using = "//div[@class='check_box']//input[@id='other']")
	public WebElement leftPaneOtherCheckbox;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Total Leads')]")
	public WebElement leftPaneTotalLeadsCount;
	
	//Leads title
	@FindBy(how = How.XPATH, using = "//div[@class='title']//span[@id='create_lead_title']")
	public WebElement leadTitle;
	@FindBy(how = How.XPATH, using = "//div/a[contains(text(),'Create Lead')]")
	public WebElement createLeadLink; 

	}
