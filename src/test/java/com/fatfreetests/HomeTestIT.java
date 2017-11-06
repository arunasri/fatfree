package com.fatfreetests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pageobjects.HomePO;
import com.pageobjects.LoginPagePO;

public class HomeTestIT {
	public Logger logger = Logger.getLogger(this.getClass().getName());

	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod(alwaysRun = true)
	public void SetUp() {
		// Initializing the logger
		DOMConfigurator.configure("log4j.xml");

		driver = new ChromeDriver();
		baseUrl = "http://qacrm.herokuapp.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
	
	public void baseCode() {
		driver.get(baseUrl);
		LoginPagePO login = new LoginPagePO(driver);
		login.username.sendKeys("george");
		login.password.sendKeys("george");
		logger.info("entering login page");
		login.loginButton.click();
		// Given I am on login page
		logger.info("authenticating as george");

	}

	@Test(priority = 4)
	public void testHeaderMenuLinks() {
		this.baseCode();
		SoftAssert logInAssert = new SoftAssert();
		HomePO homePO = new HomePO(driver);
		// Then verify all tabs in home page
		logger.info("asserting home page links");
		logInAssert.assertEquals(homePO.homeLink.getText(), "Fat Free CRM", "Fat Free CRM link is not present");
		logger.info("Fat Free CRM link is present");
		// Main menu links
		logInAssert.assertEquals(homePO.welcomeUsername.getText(), "George", "User is not logged in as George");
		logger.info("User is logged in as George");
		logInAssert.assertEquals(homePO.quickFindLink.getText(), "Quick find", "Quick find link is not present");
		logger.info("Quick find link is present");
		logInAssert.assertEquals(homePO.profileLink.getText(), "Profile", "Profile link is not present");
		logger.info("Profile link is present");
		logInAssert.assertEquals(homePO.logoutLink.getText(), "Logout", "Logout link is not present");
		logger.info("Logout link is present");
		logInAssert.assertAll();

	}

	@Test(priority = 4)
	public void testTabs() {
		this.baseCode();
		HomePO homePO = new HomePO(driver);
		SoftAssert logInAssert = new SoftAssert();
		// Home page tabs
		logInAssert.assertEquals(homePO.dashboardTab.getText(), "Dashboard", "Dashboard tab is not present");
		logger.info("Dashboard tab is present");
		logInAssert.assertEquals(homePO.tasksTab.getText(), "Tasks", "Tasks link is not present");
		logger.info("Tasks link is present");
		logInAssert.assertEquals(homePO.campaignsTab.getText(), "Campaigns", "Campaigns link is not present");
		logger.info("Campaigns link is present");
		logInAssert.assertEquals(homePO.leadsTab.getText(), "Leads", "Leads link is not present");
		logger.info("Leads link is present");
		logInAssert.assertEquals(homePO.accountsTab.getText(), "Accounts", "Accounts link is not present");
		logger.info("Accounts link is present");
		logInAssert.assertEquals(homePO.contactsTab.getText(), "Contacts", "Contacts link is not present");
		logger.info("Contacts link is present");
		logInAssert.assertEquals(homePO.opportunitiesTab.getText(), "Opportunities",
				"Opportunities link is not present");
		logger.info("Opportunities link is present");
		logInAssert.assertEquals(homePO.teamTab.getText(), "Team", "Team link is not present");
		logger.info("Team link is present");
		logInAssert.assertAll();

	}

	@Test(priority = 4)
	public void testLeftPaneLists() {
		this.baseCode();
		HomePO homePO = new HomePO(driver);
		SoftAssert logInAssert = new SoftAssert();
		// Left pane lists
		logInAssert.assertEquals(homePO.globalLists.getText(), "Global lists", "Global lists should not be displayed");
		logger.info("Global lists should be displayed");
		logInAssert.assertEquals(homePO.myLists.getText(), "My lists", "My lists should not be displayed");
		logger.info("My lists should be displayed");
		logInAssert.assertEquals(homePO.recentItems.getText(), "Recent Items", "Recent Items should not be displayed");
		logger.info("Recent Items should be displayed");
		logInAssert.assertAll();

	}

	@Test(priority = 4)
	public void testMainPageLists() {
		this.baseCode();
		HomePO homePO = new HomePO(driver);
		SoftAssert logInAssert = new SoftAssert();
		// Main page lists
		logInAssert.assertEquals(homePO.mainMyTasks.getText(), "My Tasks", "My Tasks items are not displayed");
		logger.info("Main items will be displayed");
		logInAssert.assertEquals(homePO.mainMyOpportunities.getText(), "My Opportunities",
				"My Opportunities items are not displayed");
		logger.info("My Opportunities items will be displayed");
		logInAssert.assertEquals(homePO.mainMyAccounts.getText(), "My Accounts", "My Accounts items are not displayed");
		logger.info("My Accounts items will be displayed");
		logInAssert.assertEquals(homePO.mainRecentActivity.getText(), "Recent Activity",
				"Recent Activity items are not displayed");
		logger.info("Recent Activity items will be displayed");
		// Options link details
		logInAssert.assertTrue(isElementOnThePage(homePO.mainOptions),  "Options links should be disaplayed ");
		logger.info("Options items will be displayed");
		// logInAssert.assertEquals(homePO.optionsActivitiesLink.getText(),
		// "Activities","Activities items are not displayed");
		// logger.info("Activities items will be displayed");
		// logInAssert.assertEquals(homePO.optionsAllUsersLink.getText(), "All
		// Users","All Users items are not displayed");
		// logger.info("All Users items will be displayed");
		// logInAssert.assertEquals(homePO.optionsTwoDaysLink.getText(), "Two
		// Days", "Two Days items are not displayed");
		// logger.info("Two Days items will be displayed");
		// logInAssert.assertEquals(homePO.optioncloseLink.getText(), "Close",
		// "Close link is not displayed");
		// logger.info("Close link will be displayed");
		// Export Files
		logInAssert.assertEquals(homePO.exportXLSFile.getText(), "XLS", "XLS file is not available");
		logger.info("XLS file is available");
		logInAssert.assertEquals(homePO.exportCSVFile.getText(), "CSV", "CSV file is not available");
		logger.info("CSV file is available");
		logInAssert.assertEquals(homePO.exportRSSFile.getText(), "RSS", "RSS file is not available");
		logger.info("RSS file is available");
		logInAssert.assertEquals(homePO.exportATOMFile.getText(), "ATOM", "ATOM file is not available");
		logger.info("ATOM file is available");
		logInAssert.assertEquals(homePO.exportPERMFile.getText(), "PERM", "PERM file is not available");
		logger.info("PERM file is available");

		logInAssert.assertAll();

	}

	public boolean isElementOnThePage(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
