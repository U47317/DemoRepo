package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	private LoginPage loginPage;
	private HomePage homePage;
	Logger logg=Logger.getLogger(LoginPageTest.class);
	public LoginPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		
	}
	
	
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
	logg.info("**********************Validate Login Page Test************************");
	String title=loginPage.validateLoginPageTitle();
	Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	logg.info("**********************END of Validate Login Test Page Test*********************************************");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		logg.info("********************CRM Logo Image Test******************************************");
		boolean flag=loginPage.validateCRMImage();
		Assert.assertTrue(flag);
		logg.info("********************End of CRM Logo Test*****************************************");
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		logg.info("********************Login Test************************************************");
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		logg.info("********************End of Login Test******************************************");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
