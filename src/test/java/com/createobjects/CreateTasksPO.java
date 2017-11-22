package com.createobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateTasksPO {
	public WebDriver driver;
	public CreateTasksPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Create Task")
	public WebElement createTaskTitle;
	@FindBy(how = How.ID, using = "task_name")
	public WebElement taskName;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'label')][0]")
	public WebElement nameLabel;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'label')][1]")
	public WebElement dueLabel;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'label')][2]")
	public WebElement assignToLabel;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'label')][3]")
	public WebElement categoryLabel;
	
	@FindBy(how = How.ID, using = "task_name")
	public WebElement nameTextfield;
	@FindBy(how = How.ID, using = "task_bucket")
	public WebElement dueDropDownField;
	@FindBy(how = How.ID, using = "select2-task_assigned_to-container")
	public WebElement assignToDropDownField;
	@FindBy(how = How.ID, using = "task_category")
	public WebElement categoryDropDownField;
	@FindBy(how = How.XPATH, using = "//input[@value='Create Task']")
	public WebElement createTaskButton;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Cancel")
	public WebElement cancelLink;
	

}
