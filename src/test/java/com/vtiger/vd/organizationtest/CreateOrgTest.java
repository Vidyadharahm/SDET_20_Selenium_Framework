package com.vtiger.vd.organizationtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.vd.genericUtility.BaseClass;
import com.vtiger.vd.objectrepositorylib.CreateOrganizationPage;
import com.vtiger.vd.objectrepositorylib.Home;
import com.vtiger.vd.objectrepositorylib.Organization;
import com.vtiger.vd.objectrepositorylib.OrganizationInfoPage;

public class CreateOrgTest extends BaseClass {

	@Test(groups = {"smokeTest", "regressionTest"})
	public void createOrgRatingTest() throws Throwable {
		
		test = reports.createTest("createOrgRatingTest");

		Home homePage = new Home(driver);
		homePage.homePageVerification();
		homePage.getOrganizationLink().click();
		// if want to logout of application then we can use ""homePage.Logout();""

		Organization org = new Organization(driver);
		org.organizationVerification();
		org.getCreateOrgBtn().click();

		CreateOrganizationPage createOrg = new CreateOrganizationPage(driver);
		createOrg.verifyTheCreateOrgPage();
		String orgName = excelLib.getDataFromExcel("Sheet1", 4, 2) + randomNum;
		createOrg.createOrg(orgName, "Active");

		OrganizationInfoPage orgInfoPage = new OrganizationInfoPage(driver);
		String actualHeaderMsg = orgInfoPage.getHeaderText().getText();
		
		boolean successfulMsg = actualHeaderMsg.contains(orgName);
		Assert.assertTrue(successfulMsg);

		/*if (actualHeaderMsg.contains(orgName)) {
			System.out.println(orgName + "\t" + "Organization is created with the Org name ====>> PASS");
		} else {
			System.out.println(orgName + "\t" + "Organization is not created with the Org name ====>> FAIL");
		}*/
	}

	@Test(groups = {"regressionTest"})
	public void createOrgWithNotifyTest() throws Throwable {
		
		test = reports.createTest("createOrgWithNotifyTest");

		Home homePage = new Home(driver);
		homePage.homePageVerification();
		homePage.getOrganizationLink().click();

		Organization org = new Organization(driver);
		org.organizationVerification();
		org.getCreateOrgBtn().click();

		CreateOrganizationPage createOrg = new CreateOrganizationPage(driver);
		createOrg.verifyTheCreateOrgPage();
		String orgName = excelLib.getDataFromExcel("Sheet1", 5, 2) + randomNum;
		createOrg.checkBox(orgName);

		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		String actualHeaderMsg = orgInfo.getHeaderText().getText();
		
		boolean successfulMsg = actualHeaderMsg.contains(orgName);
		Assert.assertTrue(successfulMsg);
		
		/*if (actualHeaderMsg.contains(orgName)) {
			System.out.println(orgName + "\t" + "Organization is created with the Org name ====>> PASS");
		} else {
			System.out.println(orgName + "\t" + "Organization is not created with the Org name ====>> FAIL");
		}*/
	}

	@Test(groups = {"regressionTest"})
	public void createOrgCheckNotifyTest() throws Throwable {
		
		test = reports.createTest("createOrgCheckNotifyTest");

		Home homePage = new Home(driver);
		homePage.homePageVerification();
		homePage.getOrganizationLink().click();

		Organization org = new Organization(driver);
		org.organizationVerification();
		org.getCreateOrgBtn().click();

		CreateOrganizationPage createOrg = new CreateOrganizationPage(driver);
		createOrg.verifyTheCreateOrgPage();
		String orgName = excelLib.getDataFromExcel("Sheet1", 6, 2) + randomNum;
		createOrg.checkBox(orgName, true);

		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		String actualHeaderMsg = orgInfo.getHeaderText().getText();
		
		boolean successfulMsg = actualHeaderMsg.contains(orgName);
		Assert.assertTrue(successfulMsg);
		
		/*if (actualHeaderMsg.contains(orgName)) {
			System.out.println(orgName + "\t" + "Organization is created with the Org name ====>> PASS");
		} else {
			System.out.println(orgName + "\t" + "Organization is not created with the Org name ====>> FAIL");
		}*/
	}

}
