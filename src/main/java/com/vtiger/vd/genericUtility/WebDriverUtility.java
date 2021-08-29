package com.vtiger.vd.genericUtility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This method contains all the WebDriver generic methods
 * 
 * @author Vidyadhara
 *
 */
public class WebDriverUtility {

	/**
	 * This method wait until 15 second for page loading
	 * 
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public void maxi(WebDriver driver ) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to refresh the page
	 * @param driver
	 */
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	/**
	 * This method waits for the elements to load
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementLoading(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method wait for the element to be clicked , its custom wait created to
	 * avoid ElementInterAcceptablesException
	 * 
	 * @param element
	 * @throws throwable
	 * 
	 */

	public void waitAndClick(WebElement element) throws InterruptedException {
		int count = 0;
		while (count < 20) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}

	}

	/**
	 * This method is used to handle the dropdown using visibleText
	 * 
	 * @param element
	 * @param option
	 */
	public void select(WebElement element, String option) {
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}

	/**
	 * This method is used to handle the dropdown by using index
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method is used to perform mouse hovering to respective element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHovering(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * This method is used to perform mouse hovering using offset
	 * 
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	public void mouseHoverUsingOffset(WebDriver driver, WebElement element, int x, int y) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element, x, y).perform();
	}

	/**
	 * This method performs right click operation
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	/**
	 * This method helps to switch from one window to another window
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> iterator = window.iterator();
		while (iterator.hasNext()) {
			String windowId = iterator.next();
			String title = driver.switchTo().window(windowId).getTitle();
			if (title.contains(partialWindowTitle)) {
				break;
			}

		}

	}

	/**
	 * This method Accepts the alert
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method used to Cancel the Alert
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method used for scrolling action in a webpage
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", element);
	}
	
	/**
	 * This method used to switch between the frames by index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
    
	/**
	 * This method used to switch between the frames by element
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method used to switch between the frames by Id or name
	 * @param driver
	 * @param idOrName
	 */
	public void switchFrame(WebDriver driver, String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	/**
	 * This method used to take screeshot
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" + screenshotName + ".PNG");
		Files.copy(src, dest);
	}

	/**
	 * this method is used to pass the enter Key in to Browser
	 * 
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

}
