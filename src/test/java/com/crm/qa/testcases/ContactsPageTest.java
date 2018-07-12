package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import org.apache.log4j.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="contacts";
	Logger log = Logger.getLogger(ContactsPageTest.class);
	
	ContactsPageTest()
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
		testUtil.switchToFrame("mainpanel");
		contactsPage=homePage.clickOnContactsLink();
		
	}
	
	
	@Test(priority=1)
	public void validateContactsPageLabel()
	{
		log.info("*********************Validate Contacts Page Label*************************");
		Assert.assertTrue(contactsPage.validateContactsLabel(),"Contacts label is missing on the page");
		log.info("*********************End of validate Contacts Page Label********************");
	}
	
	@Test(priority=2)
	public void validateSingleContactSelectTest()
	{
		log.info("**********************Validate Single Contact Selection Test*********************");
		contactsPage.clickOnSingleContact();
		log.info("**********************End of Validate Single Contact Selection Test********************");
	}
	
	
	@DataProvider
	public Object[][] testdataFeed()
	{
		return TestUtil.getTestData(sheetName);
		
	}
	
	@Test(priority=3,dataProvider="testdataFeed")
	public void validaeCreateNewContactTest(String title,String firstName,String lastName,String company)
	{
		log.info("*******************Validate Create New Contact Test************************");
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstName, lastName, company);
		log.info("******************End validate Create New Contact Test**********************");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
