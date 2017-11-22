package com.fatfreetests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.createobjects.CreateTasksPO;
import com.pageobjects.DashboardPO;
import com.pageobjects.LoginPagePO;
import com.pageobjects.TasksPO;

import junit.framework.Assert;

public class TasksOperationsIT {
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
	}	
		//Highlight Code
	   public static void flash(WebElement element, WebDriver driver){
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				String bgcolor = element.getCssValue("backgroundColor");
				for(int i = 0; i < 100; i++) {
					changeColor("rgb(0,200,0)", element, driver);
					changeColor(bgcolor, element, driver);
				}
			}
		public static void changeColor(String color, WebElement element, WebDriver driver) {
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].style.backgroundColor = '" +color+ "'", element);

				try {
					Thread.sleep(20);
				}catch(InterruptedException e ) {
			 	
				}

	}

	@Test
	public void tasksDelete() {
		this.baseCode();
		SoftAssert checkAssert = new SoftAssert();
		DashboardPO tabs = new DashboardPO(driver);
		tabs.tasksTab.click();
		checkAssert.assertEquals(tabs.tasksTab.getText(), "Tasks", "Tasks title is not present");
		logger.info("Tasks title is present");
		// Verifying Tasks title
		WebDriverWait waitUntilTaskPageOpens = new WebDriverWait(driver, 30);
		waitUntilTaskPageOpens
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class = 'title']"))));
		logger.info("verified tasks title is present");
		// Clicking on create task link
		TasksPO tasksPage = new TasksPO(driver);
		tasksPage.createTaskLink.click();
		// Verifying create task page is opened
		WebDriverWait waitUntilCreateTaskPageOpens = new WebDriverWait(driver, 30);
		waitUntilCreateTaskPageOpens.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class = 'label top req']"))));
		logger.info("verified create task name is present");
		CreateTasksPO createTask = new CreateTasksPO(driver);
		double random = Math.random();
		String taskName = "New Task " + random;
		createTask.nameTextfield.sendKeys(taskName);
		logger.info("creating task" + taskName);

		Select due = new Select(driver.findElement(By.name("task[bucket]")));
		due.selectByVisibleText("This Week");
		logger.info("This week is selected in Due dropdown");
		Actions action = new Actions(driver);
		action.moveToElement(createTask.assignToDropDownField);
		action.click();
		action.sendKeys("Myself");
		action.build().perform();
		driver.findElement(By.className("select2-results__option--highlighted")).click();
		logger.info("Myself is selected in assign to dropdown");
		Select category = new Select(driver.findElement(By.id("task_category")));
		category.selectByVisibleText("Lunch");
		logger.info("Lunch is selected in Category dropdown");

		createTask.createTaskButton.click();
		logger.info("Create task is created successfully");
		String taskXPath = "//label[contains(text(),'" + taskName + "')]";
		String deleteLinkXPath = taskXPath + "/parent::div/preceding-sibling::div/a[contains(text(),'Delete!')]";

		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath(taskXPath)))
				.moveToElement(driver.findElement(By.xpath(deleteLinkXPath))).click().build().perform();

		checkAssert.assertAll();
	}

	@Test
	public void taskDeleteElement() {
		this.baseCode();
		SoftAssert checkAssert = new SoftAssert();
		DashboardPO tabs = new DashboardPO(driver);
		tabs.tasksTab.click();
		String changing = "New Task 0.2611548162158598";
		String xpath = "//label[contains(text(),'" + changing + "')]";
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath(xpath)))
				.moveToElement(driver.findElement(
						By.xpath(xpath + "/parent::div/preceding-sibling::div/a[contains(text(),'Delete!')]")))
				.click().build().perform();
		checkAssert.assertAll();
		List<WebElement> elements = driver.findElements(By.xpath(""));
		elements.size();
	}

	@Test
	public void testOverdueList() {
		this.baseCode();
		DashboardPO tabs = new DashboardPO(driver);
		tabs.tasksTab.click();
		
		String overdueCount = driver
				.findElement(By.xpath("//div[@class='check_box']//input[@value='overdue']//preceding-sibling::div"))
				.getText();
		logger.info("overdue list " + overdueCount);
		int overdueListCount = driver.findElements(By.xpath("//div[@id='list_overdue']//li")).size();
		Assert.assertEquals(overdueListCount, Integer.parseInt(overdueCount));
		
	}
	@Test
	public void testAsSoonAsPossible() {
		this.baseCode();
		DashboardPO tabs = new DashboardPO(driver);
		tabs.tasksTab.click();
		String asSoonAsPossibleCount = driver
				.findElement(By.xpath("//div[@class='check_box']//input[@value='due_asap']//preceding-sibling::div"))
				.getText();
		logger.info("as soon as possible list " + asSoonAsPossibleCount);
		int asSoonAsPossibleListCount = driver.findElements(By.xpath("//div[@id='due_asap']//li")).size();
		Assert.assertEquals(asSoonAsPossibleListCount, Integer.parseInt(asSoonAsPossibleCount));
	}
	@Test
	public void testToday() {
		this.baseCode();
		
		DashboardPO tabs = new DashboardPO(driver);
		tabs.tasksTab.click();
		TasksPO task = new TasksPO(driver);
		task.todayPendingCheckbox.click();
		String todayCount = driver.findElement(By.xpath("//div[@class='check_box']//input[@value='due_today']//preceding-sibling::div"))
				.getText();
		logger.info("today list " + todayCount);
		int todayListCount = driver.findElements(By.xpath("//div[@id='list_due_today']//li")).size();
		Assert.assertEquals(todayListCount, Integer.parseInt(todayCount));
		}
}
