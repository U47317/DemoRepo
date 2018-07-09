package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
LoginPage loginPage;
HomePage homePage;
TestUtil testUtil;
ContactsPage contactsPage;
	HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage=new LoginPage();
		testUtil = new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	
	@Test(priority=1)
	public void HomePageTitleTest()
	{
		String title=homePage.validateTitle();
		Assert.assertEquals(title, "CRMPRO","Home Page title is incorrect");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest()
	{
		testUtil.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		 testUtil.switchToFrame("mainpanel");
		 contactsPage=homePage.clickOnContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
