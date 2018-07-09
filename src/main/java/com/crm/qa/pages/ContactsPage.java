package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//*[@id="+"ContactsForm"+"]/table/tbody/tr[5]/td[1]/input")
	WebElement singleContact;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(xpath="//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement saveButton;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void clickOnSingleContact()
	{
		singleContact.click();
	}
	
	public void createNewContact(String titleValue,String ftName,String ltName,String company)
	{
		Select select = new Select(title);
		select.selectByVisibleText(titleValue);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		companyName.sendKeys(company);
		saveButton.click();
		
		
	}
	
	
	

	
	
}