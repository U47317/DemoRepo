package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;




import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListner;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public WebEventListner webEventListner;
	
	//Logger log = Logger.getLogger(TestBase.class);
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("G:\\workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
			//log.info("Loaded Configuration file....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "G:\\workspace\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			//log.info("Launching google chrome browser....");
			
		}
		else if(browserName.equals("firefox"))
		{
			System.getProperty("webdriver.gecko.driver", "G:\\workspace\\firefoxdriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			//log.info("Launching Firefox browser...");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		webEventListner = new WebEventListner();
		e_driver.register(webEventListner);
		driver=e_driver;
		//log.info("EventFiringWebDriver activated....");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		//log.info("URL launched successfully");
		
			 
	}
	
}
