package com.vtiger.vd.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.vd.genericUtility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{
	
	WebDriver driver = null;
	
	public CreateOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@name='accountname']")
	private WebElement orgNameTF;
	
	@FindBy (xpath = "//input[@name='website']")
	private WebElement websiteTF;
	
	@FindBy (id="tickersymbol")
	private WebElement tickerSymbolTF;
	
	@FindBy (xpath = "//select[@name='industry']")
	private WebElement industryDropDown;
	
	@FindBy (xpath = "//select[@name='rating']")
	private WebElement ratingDropDown;
	
	@FindBy (xpath = "//input[@name='notify_owner']")
	private WebElement checkBox;
	
	@FindBy (xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy (xpath = "//span[text()='Creating New Organization']")
	private WebElement header;

	public WebElement getHeader() {
		return header;
	}

	public WebElement getAccountNameTF() {
		return orgNameTF;
	}

	public WebElement getWebsiteTF() {
		return websiteTF;
	}

	public WebElement getTickerSymbolTF() {
		return tickerSymbolTF;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getRatingDropDwon() {
		return ratingDropDown;
	}
	
	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg (String orgName) {
		orgNameTF.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrg (String orgName , String rating) {
		orgNameTF.sendKeys(orgName);
		select(ratingDropDown, rating);
		if(ratingDropDown.isEnabled()) { 
		      System.out.println("Dropdown is enabled"); 
		   } else { 
		      System.out.println("Dropdown is not visible"); 
		  }   
		saveBtn.click();
	}
	
	
	public void checkBox (String orgName) {
		orgNameTF.sendKeys(orgName);
		checkBox.click();
		if(checkBox.isSelected()) {
			System.out.println("CheckBox is Selected");
		} else {
			System.out.println("CheckBox is not selected");
		}
		saveBtn.click();
	}
	
	public void checkBox (String orgName , boolean flag) {
		orgNameTF.sendKeys(orgName);
		checkBox.click();
		checkBox.click();
		if(checkBox.isEnabled()) {
			System.out.println("CheckBox is Selected");
		} else {
			System.out.println("CheckBox is not selected");
		}
		saveBtn.click();
	}
	
	public void verifyTheCreateOrgPage () {
		if(header.isDisplayed()) {
			System.out.println("Create Oraganization page is Displayed");
		} else {
			System.out.println("Create Oraganization page is not Displayed");
		}
		
	}
	
}
