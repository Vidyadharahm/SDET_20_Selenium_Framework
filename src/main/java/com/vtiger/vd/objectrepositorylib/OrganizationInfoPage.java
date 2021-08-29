package com.vtiger.vd.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver = null;
	
	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	@FindBy (xpath = "//input[@name='Edit']")
	private WebElement editBtn;
	
	@FindBy (xpath = "//input[@name='Delete']")
	private WebElement deleteBtn;
	
	@FindBy (xpath = "//input[@name='Duplicate']")
	private WebElement duplicateBtn;
	
	@FindBy (xpath = "//td[@id='mouseArea_Rating']//font")
	private WebElement verifyRatingTF;

	public WebElement getVerifyRatingTF() {
		return verifyRatingTF;
	}

	public WebElement getHeaderText() {
		return headerText;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getDuplicateBtn() {
		return duplicateBtn;
	}
	
}
