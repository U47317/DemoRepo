package com.crm.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;


public class WebEventListner implements WebDriverEventListener{

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		System.out.println("Alert Accepted");
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		System.out.println("Alert Dismissed");
		
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1,
			CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver arg1) {
		System.out.println("Clicked on element "+element.toString());
		
	}

	@Override
	public void afterFindBy(By arg0, WebElement element, WebDriver arg2) {
		//System.out.println("Found "+element.toString());
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		System.out.println("Screenshot captured");
		
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("Navigated back");
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		System.out.println("Navigated Forward");
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("Switched to window "+arg0);
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver arg1,
			CharSequence[] arg2) {
		System.out.println("Changing element value "+element.toString());
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver arg1) {
		System.out.println("Trying to click on "+element.toString());
		
	}

	@Override
	public void beforeFindBy(By arg0, WebElement element, WebDriver arg2) {
		//System.out.println("Trying to find element "+element.toString());
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		System.out.println("Trying to take screenshot ");
		
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("Trying to switch to window");
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		System.out.println("Exception occured: "+arg0);
		try{
			TestUtil.takeScreenshotAtEndOfTest();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
