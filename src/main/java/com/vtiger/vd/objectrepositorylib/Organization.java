package com.vtiger.vd.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {
	
	WebDriver driver = null;
	
	public Organization (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgBtn;
	
	@FindBy (xpath = "//img[@title='Search in Organizations...']")
	private WebElement searchInOrgBtn;
	
	@FindBy (xpath = "//input[@type='button'][@value='Delete']")
	private WebElement deleteBtn;
	
	@FindBy (xpath = "//input[@name='submit']")
	private WebElement searchNowBtn;
	
	@FindBy (xpath = "//td[text()='[x]'][@style='cursor: pointer;']")
	private  WebElement terminateSearchBar;
	
	@FindBy (xpath = "//div[@id='searchAcc']")
	private WebElement searchBar;
	
	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getTerminateSearchBar() {
		return terminateSearchBar;
	}

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}

	public WebElement getSearchInOrgBtn() {
		return searchInOrgBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	public void organizationVerification() {
		String expectedTitle = "Organizations";
		String actualTitle = driver.getTitle();
		if(actualTitle.contains(expectedTitle)) {
			System.out.println("Organization page is displayed");
		} else {
			System.out.println("Organization page is not displayed");
		}	
	}
	
	public void terminateSearchBarInOrg() {
		if(searchBar.isDisplayed()) {
			System.out.println("Search bar is not closed");
		}
		
		Actions actions = new Actions(driver);
		actions.moveToElement(terminateSearchBar).click().perform();
		
		if(searchBar.isDisplayed()) {
			System.out.println("Search bar is not closed");
		} else {
			System.out.println("Search bar is closed from the organization page");
		}
		
	}
	

}
