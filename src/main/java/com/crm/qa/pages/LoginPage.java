package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase{

	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginPageTitle()
	{
		 return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String uname,String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		/*Actions actions = new Actions(driver);
		actions.moveToElement(loginBtn).click().perform();*/
		
		loginBtn.click();
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new HomePage();
	}
	
}
