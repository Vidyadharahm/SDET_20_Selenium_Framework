package com.vtiger.vd.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	//Driver goes to the browser and execute all the annotations and store it in webelement
	public Login (WebDriver driver) {
		PageFactory.initElements(driver , this);
	}                // it is a method and execute the annotation and initialize the element
	
	@FindBy (name="user_name")
	private WebElement userNameTextFeild;
	
	@FindBy (name="user_password")
	private WebElement userPasswordTextFeild;
	
	@FindBy (id="submitButton")
	private WebElement loginBtn;
	
	@FindBy (xpath = "//div[contains(text(),'Powered by vtiger CRM')]")
	private WebElement verificationText;

	public WebElement getVerificationText() {
		return verificationText;
	}

	public WebElement getUserName() {  /////Getter method
		return userNameTextFeild;
	}

	public WebElement getUserPassword() {
		return userPasswordTextFeild;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToVtiger(String userName , String userPassword) {
		userNameTextFeild.sendKeys(userName);
		userPasswordTextFeild.sendKeys(userPassword);
		loginBtn.click();
		
	}
	
	public void loginVerification() {
		if(verificationText.isDisplayed()) {
		System.out.println("Login page is displayed");
		} else {
			System.out.println("Login page is not diplayed");
		}
	}
	

}
