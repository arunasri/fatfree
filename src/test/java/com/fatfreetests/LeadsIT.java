package com.fatfreetests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.createobjects.CreateLeadPO;
import com.pageobjects.DashboardPO;
import com.pageobjects.LeadsPO;
import com.pageobjects.LoginPagePO;

public class LeadsIT {
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
	public void teardown() {
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
		// checkAssert
	}

	@Test
	public void testVerifyLeadTitle() {
		this.baseCode();
		SoftAssert checkAssert = new SoftAssert();
		DashboardPO tabs = new DashboardPO(driver);
		tabs.leadsTab.click();
		logger.info("Lead tab is present");
		checkAssert.assertEquals(tabs.leadsTab.getText(), "Leads", "Leads title is not present");
		logger.info("Leads title is present");
		// Verifying Leads title
		WebDriverWait waitUntilLeadPageOpens = new WebDriverWait(driver, 30);
		waitUntilLeadPageOpens
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class = 'title']"))));
		logger.info("verified leads title is present");
	}

	@Test
	public void testVerifyCreateLeadPage() {
		this.baseCode();
		SoftAssert checkAssert = new SoftAssert();
		DashboardPO tabs = new DashboardPO(driver);
		tabs.leadsTab.click();
		// Clicking on create lead link
		LeadsPO leadPage = new LeadsPO(driver);
		leadPage.createLeadLink.click();
		// Verifying create lead page is opened
		WebDriverWait waitUntilCreateLeadPageOpens = new WebDriverWait(driver, 30);
		waitUntilCreateLeadPageOpens.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class = 'label req top']"))));
		logger.info("verified create lead name is present");
	}

	
	
	@Test
	public void testCreateLead() {
		CreateLeadPO createLead = new CreateLeadPO(driver);
		double random = Math.random();
		String leadName = "New Lead " + random;
		createLead.leadFirstName.sendKeys(leadName);
		logger.info("creating lead" + leadName);
		// createLead.leadFirstName.sendKeys("Steve");
		createLead.leadLastName.sendKeys("Eddings");
		createLead.leadEmail.sendKeys("test@gmail.com");
		createLead.leadPhone.sendKeys("123-456-7890");
		createLead.createLeadButton.click();
		logger.info("Create lead is created successfully");
		// Deleting the Lead
		String changing = "New Lead 0.45578848689972995";
		String xpath = "//label[contains(text(),'" + changing + "')]";
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath(xpath)))
				.moveToElement(driver.findElement(By.xpath(
						xpath + ("//a[contains(text(), 'New Lead 0.45578848689972995Steve Eddings')]//parent::div/preceding-sibling::ul//a[contains(text(),'Delete!')]"))))
				.click().build().perform();
		// checkAssert.assertAll();
		List<WebElement> elements = driver.findElements(By.xpath(""));
		elements.size();

		String leadXPath = "//label[contains(text(),'" + leadName + "')]";
		String deleteLinkXPath = leadName
				+ "//a[contains(text(), 'New Lead 0.45578848689972995Steve Eddings')]//parent::div/preceding-sibling::ul//a[contains(text(),'Delete!')]";
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.xpath(leadXPath)))
				.moveToElement(driver.findElement(By.xpath(deleteLinkXPath))).click().build().perform();

		// checkAssert.assertAll();
	}
}
