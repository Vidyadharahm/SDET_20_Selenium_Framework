package com.vtiger.vd.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.vd.genericUtility.WebDriverUtility;

public class Home extends WebDriverUtility {
	
	WebDriver driver = null;
	
	public Home (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	
	@FindBy (linkText = "Leads")
	private WebElement leadLink;
	
	@FindBy (linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy (linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy (linkText = "Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy (linkText = "Products")
	private WebElement productsLink;
	
	@FindBy (xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImage;
	
	@FindBy (linkText = "Sign Out")
	private WebElement signOutLink;

	public WebElement getLeadLink() {
		return leadLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getAdministratorImage() {
		return administratorImage;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public void Logout() {
		mouseHovering(driver, administratorImage);
		signOutLink.click();
		System.out.println("Logged out of the Application");
	}
	
	public void homePageVerification() {
		if(administratorImage.isDisplayed()) {
			System.out.println("Home Page is Displayed");
		} else {
			System.out.println("Home Page is not Displayed");
		}
	}
	
	

}
