package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	 @FindBy(xpath="/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]/font")
	 WebElement usernameLabel;
	 
	 @FindBy(xpath="//a[contains(text(),'Contacts')]")
	 WebElement contactsLink;
	 
	 @FindBy(xpath="//a[contains(text(),'Deals')]")
	 WebElement dealsLink;
	 
	 @FindBy(xpath="//a[contains(text(),'Tasks')]")
	 WebElement tasksLink;
	 
	 @FindBy(xpath="//a[@title='New Contact']")
	 WebElement newContactLink;
	 
	 
	 public HomePage()
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public String validateTitle()
	 {
		return  driver.getTitle();
	 }
	 
	 public boolean verifyCorrectUserName()
	 {
		 return usernameLabel.isDisplayed();
	 }
	 public ContactsPage clickOnContactsLink()
	 {
		 contactsLink.click();
		 return new ContactsPage();
	 }
	 
	 public void clickOnNewContactLink()
	 {
		 /*Actions action = new Actions(driver);
		 action.moveToElement(contactsLink).build().perform();*/
		 contactsLink.click();
		 newContactLink.click();
		 
		 
	 }
	 
	 public DealsPage clickOnDealsLink()
	 {
		 dealsLink.click();
		 return new DealsPage();
		 
	 }
	 
	 public TasksPage clickOnTasksLink()
	 {
		 tasksLink.click();
		 return new TasksPage();
	 }
	 
	 
	
	
}
