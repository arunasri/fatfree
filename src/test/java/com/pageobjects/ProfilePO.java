package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProfilePO {
	public WebDriver driver;
	public ProfilePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "My Profile")
	public WebElement myProfileTitle;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Edit Profile")
	public WebElement editProfileTitle;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Upload Picture")
	public WebElement uploadPictureTitle;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Change Password")
	public WebElement changePasswordTitle;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "profile")
	public WebElement profileDetails;
	

}
