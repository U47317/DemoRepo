package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

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
Logger log=Logger.getLogger(HomePageTest.class);
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
		log.info("****************Home Page Title Test****************************");
		String title=homePage.validateTitle();
		Assert.assertEquals(title, "CRMPRO","Home Page title is incorrect");
		log.info("****************End of Home Page Title Test*********************");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest()
	{
		log.info("*****************Verify Username Test*****************************");
		testUtil.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyCorrectUserName());
		log.info("*****************End of Verify Username Test***********************");
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		log.info("****************Verify contacts link Test***************************"); 
		testUtil.switchToFrame("mainpanel");
		 contactsPage=homePage.clickOnContactsLink();
		 log.info("***************End of Verify Contacts link Test********************");
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
