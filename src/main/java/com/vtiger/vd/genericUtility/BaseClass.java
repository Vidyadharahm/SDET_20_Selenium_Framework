package com.vtiger.vd.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.vd.objectrepositorylib.Home;
import com.vtiger.vd.objectrepositorylib.Login;

public class BaseClass {
	public WebDriver driver;
	
	public ExtentHtmlReporter reporter;
	public ExtentReports reports;
	public ExtentTest test;
	
		public JavaUtility javaLib = new JavaUtility();
		public WebDriverUtility driverLib = new WebDriverUtility();
		public FileUtility fileLib = new FileUtility();
		public ExcelUtility excelLib = new ExcelUtility();
		
		public int randomNum = javaLib.getRandomNumber();
		
		@BeforeSuite
		public void setup() {
			reporter = new ExtentHtmlReporter("./ExtentReport/Practise.html");
			System.out.println("Before suite class executed");
			reporter.config().setDocumentTitle("V-tiger");
			reporter.config().setTheme(Theme.DARK);//this statement is for the setting the theme
			reports = new ExtentReports();
			reports.attachReporter(reporter);
		}
		
		//@Parameters("BROWSER")
		@BeforeClass(groups = {"smokeTest", "regressionTest"})
		public void configBc(/*String BROWSER*/) throws Throwable {
			String  BROWSER = fileLib.getPropertyKeyValue("browser");
			if(BROWSER.equals("chrome")) {
				driver = new ChromeDriver();
				System.out.println("Chrome Browser is launched");
			}
			
			if(BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
				System.out.println("firefox Browser is launched");
			}
			driver.manage().window().maximize();
			driverLib.waitUntilPageLoad(driver);
		}
		
		@BeforeMethod(groups = {"smokeTest", "regressionTest"})
		public void configBm() throws Throwable {
			String  URL = fileLib.getPropertyKeyValue("url");
			String USERNAME = fileLib.getPropertyKeyValue("username");
			String PASSWORD = fileLib.getPropertyKeyValue("password");
			
			driver.get(URL);
			Login loginPage = new Login(driver);
			loginPage.loginVerification();
			loginPage.loginToVtiger(USERNAME , PASSWORD);
		}
		
		@AfterMethod(groups = {"smokeTest", "regressionTest"})
		public void configAm() {
			Home homePage = new Home(driver);
			homePage.Logout();
		}
		
		@AfterClass
		public void configAc() {
			driver.quit();
		}
		
		@AfterSuite
		public void configAS() {
			reports.flush();
			System.out.println("Disconnected from Database");
		}

		
}
