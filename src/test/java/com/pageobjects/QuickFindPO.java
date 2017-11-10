package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class QuickFindPO {
	public WebDriver driver;

	public QuickFindPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Quick Find Menu bar inside links
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Campaigns")
	public WebElement quickFindCampaigns;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Accounts")
	public WebElement quickFindAccounts;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Leads")
	public WebElement quickFindLeads;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Contacts")
	public WebElement quickFindContacts;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Opportunities")
	public WebElement quickFindOpportunities;
	@FindBy(how = How.ID, using = "auto_complete_query")
	public WebElement quickFindSearch;
	
}
