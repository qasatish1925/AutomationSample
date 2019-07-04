package com.mya.scripts.AutomationTest;


import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ApplicationHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class VerifyWallethub extends DriverTestCase
{	
	@Test
	public void testVerifyWallethub() throws Exception
	{			
		//Initialize objects
		helpers = new ApplicationHelper(getWebDriver());

		//variables
		String Post = "Hello World" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to("https://wallethub.com/join/login");
			helpers.waitForWorkAroundTime(7000);
			
			//Enter Login details
			helpers.FillinData("WUserName", "testvktd15@gmail.com");
			helpers.FillinData("WPassword", "1qaz!QAZ");
			
			//Click on login button
			helpers.ClickItem("WLogin");
			helpers.waitForWorkAroundTime(7000);
			
			//Navigate to mentioned site
			getWebDriver().navigate().to("https://wallethub.com/profile/test_insurance_company/");
			helpers.waitForWorkAroundTime(10000);
			
			//Close footer
			helpers.ClickItem("CloseFooter");
			
			//Hover to the rating stars
			helpers.MouseHover();
			helpers.waitForWorkAroundTime(3000);
			
			//click on 5 star
			helpers.ClickItem("Star");
			helpers.waitForWorkAroundTime(6000);
			
			//Select Health from drop down
			helpers.ClickItem("ReviewdroDown");
			helpers.ClickItem("SelectOption");
			helpers.waitForWorkAroundTime(4000);
			
			//Select star
			helpers.ClickItem("ReviewStar");
			
			//Enter review
			helpers.EnterCharacter();
			helpers.waitForWorkAroundTime(4000);
			
			//Click on Submit button
			helpers.ClickItem("Submit");
			helpers.waitForWorkAroundTime(4000);
			
			//Navigate to profile page
			getWebDriver().navigate().to("https://wallethub.com/profile/testvktd15/");
			helpers.waitForWorkAroundTime(10000);
			
			//Verify the review on activity page
			helpers.VerifyReview();
			

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
