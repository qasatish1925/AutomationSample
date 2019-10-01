package com.mya.scripts.AutomationTest;


import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ApplicationHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class ValidateFBPage extends DriverTestCase
{	
	@Test
	public void testValidateFBPage() throws Exception
	{			
		//Initialize objects
		helpers = new ApplicationHelper(getWebDriver());

		//variables
qa
		String Post = "Hello World" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to("https://www.facebook.com/");
			
			//Enter fb account username
			helpers.FillinData("UserName", "testvktd15@gmail.com");
			
			//Enter password
			helpers.FillinData("Password", "1qaz@WSX#EDC");
			
			//Click on login button
			helpers.ClickItem("Login");
			helpers.waitForWorkAroundTime(8000);
			helpers.AllowPermssn();
			
			//Enter status
			helpers.FillinData("Status", Post);
			helpers.waitForWorkAroundTime(8000);
			
			//Click on share button
			helpers.ClickItem("Share");
			helpers.waitForWorkAroundTime(8000); 
			

		}

		catch (Error e) 
		{
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) {
			ExecutionLog.LogExceptionMessage(e);			
			throw e;
		}		
	}
	@AfterMethod
	public void endMethods() throws Exception
	{		
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
