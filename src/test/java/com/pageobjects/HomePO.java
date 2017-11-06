package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePO {
	public WebDriver driver;
	public HomePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Main Menu Bar Links
	@FindBy(how = How.LINK_TEXT, using = "Fat Free CRM")
	public WebElement homeLink;
	@FindBy(how = How.ID, using = "welcome_username")
	public WebElement welcomeUsername;
	@FindBy(how = How.LINK_TEXT, using = "Quick find")
	public WebElement quickFindLink;
	@FindBy(how = How.LINK_TEXT, using = "Profile")
	public WebElement profileLink;
	@FindBy(how = How.LINK_TEXT, using = "Logout")
	public WebElement logoutLink;
	@FindBy(how = How.LINK_TEXT, using = "Admin")
	public WebElement adminLink;
	
	//All tabs in Home Page
	@FindBy(how = How.LINK_TEXT, using = "Dashboard")
	public WebElement dashboardTab;
	@FindBy(how = How.LINK_TEXT , using = "Tasks")
	public WebElement tasksTab;
	@FindBy(how = How.LINK_TEXT, using = "Campaigns")
	public WebElement campaignsTab;
	@FindBy(how = How.LINK_TEXT, using = "Leads")
	public WebElement leadsTab;
	@FindBy(how = How.LINK_TEXT, using = "Accounts")
	public WebElement accountsTab;
	@FindBy(how = How.LINK_TEXT, using = "Contacts")
	public WebElement contactsTab;
	@FindBy(how = How.LINK_TEXT, using = "Opportunities")
	public WebElement opportunitiesTab;
	@FindBy(how = How.LINK_TEXT, using = "Team")
	public WebElement teamTab;
	
	//Left bar home page lists
	@FindBy(how = How.CSS, using = "#lists > div:nth-child(1) > div.caption")
	public WebElement globalLists;
	@FindBy(how = How.CSS, using = "#lists > div:nth-child(2) > div.caption")
	public WebElement myLists;
	@FindBy(how = How.CSS, using = "#recently > div")
	public WebElement recentItems;
	
	//Main bar home page created items will display
	@FindBy(how = How.XPATH, using = ".//span[contains(text(),'My Tasks')]")
	public WebElement mainMyTasks;
	@FindBy(how = How.XPATH, using = ".//span[contains(text(),'My Opportunities')]")
	public WebElement mainMyOpportunities;
	@FindBy(how = How.XPATH, using = ".//span[contains(text(),'My Accounts')]")
	public WebElement mainMyAccounts;
	@FindBy(how = How.XPATH, using = ".//span[contains(text(),'Recent Activity')]")
	public WebElement mainRecentActivity;
	@FindBy(how = How.PARTIAL_LINK_TEXT , using = "Options")
	public WebElement mainOptions;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "activities")
	public WebElement optionsActivitiesLink;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "all users")
	public WebElement optionsAllUsersLink;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "two days")
	public WebElement optionsTwoDaysLink;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "x")
	public WebElement optioncloseLink;
	
	//Export link in bottom page
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "XLS")
	public WebElement exportXLSFile;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "CSV")
	public WebElement exportCSVFile;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "RSS")
	public WebElement exportRSSFile;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "ATOM")
	public WebElement exportATOMFile;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "PERM")
	public WebElement exportPERMFile;
	

}
