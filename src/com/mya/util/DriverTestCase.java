package com.mya.util;

import java.io.File;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mya.pagehelper.*;

public abstract class DriverTestCase 
{

	enum DriverType 
	{ Firefox, IE, Chrome , ChromeOS}

	//Define objects
	private WebDriver driver;
	protected ApplicationHelper helpers;
	
	

	//Initialize objects
	protected PropertyReader propertyReader = new PropertyReader();

	//Define variables
	protected String baseURL = propertyReader.readApplicationFile("Base_URL");
	
	@BeforeSuite
	public void setUp() 
	{  
		String driverType = propertyReader.readApplicationFile("BROWSER");  
		String machine = propertyReader.readApplicationFile("OS");

		if (DriverType.Firefox.toString().equals(driverType)) 
		{ 
			driver = new FirefoxDriver();   
		}   
		else if (DriverType.IE.toString().equals(driverType)) 
		{ 
			String path1 = getPath();
			File file = new File(path1+"//IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);   
			driver = new InternetExplorerDriver(capabilities); 
			//driver = new InternetExplorerDriver();
		}
		
		else if (DriverType.Chrome.toString().equals(driverType)) 
		{ 
			String path1 = getPath();
			File file = new File(path1+"//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options); 
		}
		else if (DriverType.Chrome.toString().equals(driverType)) 
		{ 
			if (machine.equals("Mac")) {
				driver = new ChromeDriver();
			}
			else{

				String path1 = getPath();
				String chromeDriverPath= path1+"/chromedriver.exe";

				//Set the required properties to instantiate Chrome driver. Place any latest Chromedriver.exe files under Drivers folder
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");

				driver = new ChromeDriver(options); 
			}
		}
		else 
		{
			driver = new ChromeDriver();
		}    

		//Maximize window
		driver.manage().window().maximize();

		//Delete cookies
		//driver.manage().deleteAllCookies();   

	} 

	@AfterSuite
	public void afterMainMethod() 
	{  
		driver.quit();
	}

	public WebDriver getWebDriver()
	{
		return driver;
	}


	//Get random integer
	public int getRandomInteger(int aStart, int aEnd){
		Random aRandom = new  Random();
		if ( aStart > aEnd ) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		//get the range, casting to long to avoid overflow problems
		long range = (long)aEnd - (long)aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long)(range * aRandom.nextDouble());
		int randomNumber =  (int)(fraction + aStart);    
		return randomNumber;
	}



	//Get absolute path
	public String getPath()
	{
		String path ="";		
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");		
		return path;
	}





}



