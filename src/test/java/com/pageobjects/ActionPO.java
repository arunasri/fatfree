package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ActionPO {
//Banking Menu
	public WebDriver driver;
	@FindBy(how = How.XPATH, using = "//a[@class='first']")
	public WebElement bankingMenuElement;
//Credit cards Menu
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Credit Cards')]//parent::li")
	public WebElement creditCardsElement;
//Time website
	@FindBy(how = How.XPATH, using = "//a[@title = 'Click to show site navigation']")
	public WebElement timeShowSiteNavigation;
//Mint Website
	@FindBy(how = How.XPATH, using = "//li[@class = 'first expanded']//a[contains(text(), 'How it Works')]")
	public WebElement howItWorksMenu;
//ABC Website
	@FindBy(how = How.XPATH, using = "//div[@class = 'm-menu-global-section']//a[contains(text(), 'schedule')]")
	public WebElement abcScheduleLink;
	@FindBy(how = How.XPATH, using = "//div[@class = 'm-menu-global-section']//a[contains(text(), 'shows')]")
	public WebElement showsLink;
	
//ABC Sub Menu links
	public final String theChewLink = "//span[@class = 'navigation-group-link text-header-nav extra-light']//a[contains(text(), 'The Chew')]";
	
	
	//Mint How It Works Sub Menu links
	public final String allInOneLink = "//ul[@class = 'menu']//li[@class = 'first collapsed']";
	public final String billPayLink = "//ul[@class = 'menu']//li[@class = 'last collapsed']";
	
	
	//Time Navigation sub menu links
	public final String timeMottoMenu = "//a[@class = 'main-nav-section nav-motto']";
	public final String timeEntertainmentMenu = "//a[@data-event = 'nav-entertainment']";	
	
	//Banking Menu
	public final String checkingBankingXPathLocator = "//a[@name='checking_']";
	public final String mobileBankingXPathLocator = "//a[@name='mobile_banking']";
	//Credit cards Menu
	String amazonDeptBooksAudibleXPathLocator = "//span[contains(text(), 'Books & Audible')]";
	String amazonDeptBooksAudibleKindleBooks= "";

	public ActionPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
