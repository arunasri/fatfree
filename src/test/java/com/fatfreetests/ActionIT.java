package com.fatfreetests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.pageobjects.ActionPO;

public class ActionIT {
	public final static String seleniumGridURL = "https://arunasri:5eff05a3-a91a-41aa-90ff-0a54533fe9ba@ondemand.saucelabs.com:443/wd/hub";
	
	// Given
	// I am on bank of america website
	// When
	// I Click on banking menu
	// Then
	// I should see mobile banking links
	// name checkingMobileBankingSubmenu
	@Test
	public void testCheckingMobileBankingSubmenu() throws MalformedURLException {
		//WebDriver driver = new RemoteWebDriver(new URL(seleniumGridURL), DesiredCapabilities.chrome());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.bankofamerica.com/");
		ActionPO menuPageObject = new ActionPO(driver);
		
		Actions clickingMobileBankingAction = new Actions(driver);
		clickingMobileBankingAction.click(menuPageObject.bankingMenuElement)
				.click(driver.findElement(By.xpath(menuPageObject.mobileBankingXPathLocator))).build().perform();

		driver.quit();
	}
	
	@Test
	public void testCheckingCheckingBankingSubmenu() throws MalformedURLException {
		//WebDriver driver = new RemoteWebDriver(new URL(seleniumGridURL), DesiredCapabilities.chrome());
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.bankofamerica.com/");
		ActionPO menuPageObject = new ActionPO(driver);
	
		Actions clickingMobileBankingAction = new Actions(driver);
		clickingMobileBankingAction.click(menuPageObject.bankingMenuElement)
				.click(driver.findElement(By.xpath(menuPageObject.checkingBankingXPathLocator))).build().perform();

		driver.quit();
		
	}
	@Test
	public void testAmazonMouseOver() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://time.com/");
		ActionPO timePageObject = new ActionPO(driver);
		Actions clickingMottoMenu = new Actions(driver);
		clickingMottoMenu.click(timePageObject.timeShowSiteNavigation)
		.click(driver.findElement(By.xpath(timePageObject.timeMottoMenu))).build().perform();
		driver.quit();		
	}
	
	@Test
	public void testMintMouseOverHowItWorks1() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mint.com/");
		ActionPO mintPageObject = new ActionPO(driver);
		Actions clickingHowItWorksMenu = new Actions(driver);
		clickingHowItWorksMenu.moveToElement(mintPageObject.howItWorksMenu)
		.click(driver.findElement(By.xpath(mintPageObject.allInOneLink))).build().perform();
		driver.quit();
	}
	
	@Test
	public void testMintMouseOverHowItWorks2() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mint.com/");
		ActionPO mintPageObject = new ActionPO(driver);
		Actions clickingHowItWorksMenu = new Actions(driver);
		clickingHowItWorksMenu.moveToElement(mintPageObject.howItWorksMenu)
		.click(driver.findElement(By.xpath(mintPageObject.billPayLink))).build().perform();
		driver.quit();		
	}
	@Test
	public void testAbcWebsite1() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://abc.go.com/");
		ActionPO abcPageObject = new ActionPO(driver);
		
		Actions clickingTheChewLink = new Actions(driver);
		clickingTheChewLink.click(abcPageObject.showsLink).click
		    (driver.findElement(By.xpath(abcPageObject.theChewLink))).click().build().perform();
		
		
		
	}

}
