package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TasksPO {
	public WebDriver driver;

	public TasksPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Left Pane pending check box lists
	@FindBy(how = How.XPATH, using = "//*[@id='filters']/table/tbody/tr/td[1]")
	public WebElement leftPanePendingList;
	@FindBy(how = How.XPATH, using = "//*[@id='filters']/table/tbody/tr/td[3]")
	public WebElement leftPaneCompletedList;
	@FindBy(how = How.ID, using = "filters_overdue")
	public WebElement overduePendingCheckbox;
	@FindBy(how = How.ID, using = "filters_due_asap")
	public WebElement asSoonAsPosiblePendingCheckbox;
	@FindBy(how = How.ID, using = "filters_due_today")
	public WebElement todayPendingCheckbox;
	@FindBy(how = How.ID, using = "filters_due_tomorrow")
	public WebElement tomorrowPendingCheckbox;
	@FindBy(how = How.ID, using = "filters_due_this_week")
	public WebElement thisWeekPendingCheckbox;
	@FindBy(how = How.ID, using = "filters_due_next_week")
	public WebElement nextWeekPendingCheckbox;
	@FindBy(how = How.ID, using = "filters_due_later")
	public WebElement sometimeLaterPendingCheckbox;
	@FindBy(how = How.XPATH, using = ".//div[contains(text()='Total Pending Tasks')]")
	public WebElement totalPendingTasksPendingCheckbox;

	// Left pane Assigned check box lists
	@FindBy(how = How.XPATH, using = "//*[@id='filters']/table/tbody/tr/td[2]")
	public WebElement leftPaneAssignedList;
	@FindBy(how = How.ID, using = "filters_overdue")
	public WebElement overdueAssignedCheckbox;
	@FindBy(how = How.ID, using = "filters_due_asap")
	public WebElement asSoonAsPossibleAssignedCheckbox;
	@FindBy(how = How.ID, using = "filters_due_today")
	public WebElement todayAssignedCheckbox;
	@FindBy(how = How.ID, using = "filters_due_tomorrow")
	public WebElement tomorrowAssignedCheckbox;
	@FindBy(how = How.ID, using = "filters_due_this_week")
	public WebElement thisWeekAssignedCheckbox;
	@FindBy(how = How.ID, using = "filters_due_next_week")
	public WebElement nextWeekAssignedCheckbox;
	@FindBy(how = How.ID, using = "filters_due_later")
	public WebElement sometimeLaterAssignedCheckbox;
	@FindBy(how = How.XPATH, using = ".//div[contains(text()='Total Assigned Tasks')]")
	public WebElement totalPendingTasksAssignedCheckbox;
	// Tasks main page
	@FindBy(how = How.ID, using = "title")
	public WebElement tasksTitle;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Create Task")
	public WebElement createTaskLink;
	//@FindBy(how = How.XPATH, using = "//a[contains(@class, ''")
	
	//Export links in tasks tab

	 @FindBy(how = How.PARTIAL_LINK_TEXT, using = "XLS")
	 public WebElement tasksExportXLS;
	 @FindBy(how = How.PARTIAL_LINK_TEXT, using = "CSV")
	 public WebElement tasksExportCSV;
	 @FindBy(how = How.PARTIAL_LINK_TEXT, using = "RSS")
	 public WebElement tasksExportRSS;
	 @FindBy(how = How.PARTIAL_LINK_TEXT, using = "ATOM")
	 public WebElement tasksExportATOM;
	 @FindBy(how = How.PARTIAL_LINK_TEXT, using = "PERM")
	 public WebElement tasksExportPERM;
	 
	 //Tasks footer links
	 
	// @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Fat Free CRM")
	// public WebElement ;
	// @FindBy(how = How , using = "")
	// public WebElement ;
	// @FindBy(how = How , using = "")
	// public WebElement ;
	// @FindBy(how = How , using = "")
	// public WebElement ;
	// @FindBy(how = How , using = "")
	// public WebElement ;

}
