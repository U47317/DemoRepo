package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


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
		Assert.assertTrue(contactsPage.validateContactsLabel(),"Contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void validateSingleContactSelectTest()
	{
		contactsPage.clickOnSingleContact();
	}
	
	
	@DataProvider
	public Object[][] testdataFeed()
	{
		return TestUtil.getTestData(sheetName);
		
	}
	
	@Test(priority=3,dataProvider="testdataFeed")
	public void validaeCreateNewContactTest(String title,String firstName,String lastName,String company)
	{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
