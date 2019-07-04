package com.mya.pagehelper;

import static org.junit.Assert.assertArrayEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableBiMap.Builder;
import com.mya.locators.LocatorReader;
import com.mya.util.DriverHelper;
import com.mya.util.PropertyReader;

public class ApplicationHelper extends DriverHelper {

	private LocatorReader locator;

	public ApplicationHelper(WebDriver webdriver) {
		super(webdriver);
		locator = new LocatorReader("Locators.xml");
	}

	public void FillinData(String xmlnode, String value)
	{
		String locator1 = locator.getLocator(xmlnode);
		sendKeys(locator1, value);
	}

	//click Xml node
	public void ClickItem(String xmlnode)
	{
		String locator1 = locator.getLocator(xmlnode);
		clickOn(locator1);
	}

	//Enter 200 characters
	public void EnterCharacter()
	{
		sendKeys("//*[@id='review-content']", "Tester tester Tester tester  Tester tester  Tester tester  Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester t");
		waitForWorkAroundTime(6000);
	}
	
	//Verify Activity page
	public void VerifyReview()
	{
		WebElement msg= getWebDriver().findElement(By.xpath(".//*[@id='activity-content-12031903']/div[1]/div[2]/p[1]"));
		String msg1 = msg.getText();
		String msg2 ="Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester Tester tester t";
		Assert.assertEquals(msg1, msg2);
	}
	
	//Mouse hover
	public void MouseHover() {
		WebElement element=getWebDriver().findElement(By.xpath("//*[@class='wh-rating rating_4_5']"));
		Actions action = new Actions(getWebDriver());
		action.moveToElement(element).build().perform();

	}
	
	//Allow permission to notification
		public void AllowPermssn() {
			Robot robot = null;
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.delay(600);	
			}catch (AWTException e) {
				
			}
	
	
		}
}
