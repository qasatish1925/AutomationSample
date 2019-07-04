package com.mya.pagehelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.mya.locators.LocatorReader;
import com.mya.util.DriverHelper;


public class SFDCHelper extends DriverHelper {

	private LocatorReader sfdclocator;

	public SFDCHelper(WebDriver webdriver) {
		super(webdriver);
		sfdclocator = new LocatorReader("SDFCLocators.xml");
	}


	//Login into the testing Sandbox
	public void LoginIntoSFDC(String Gmail, String g_Username, String g_Password)
	{
		driver.navigate().to(Gmail);
		String locator_uname = sfdclocator.getLocator("Login");
		String locator_pass = sfdclocator.getLocator("Password");
		String locator_Submit = sfdclocator.getLocator("Submit");
		sendKeys(locator_uname, g_Username);
		sendKeys(locator_pass, g_Password);
		clickOn(locator_Submit);
	}
	
	
	//Login into the testing Sandbox
	public void LoginInGmail(String gmail_url, String username, String password)
	{
		driver.navigate().to(gmail_url);
		String locator_uname = sfdclocator.getLocator("AdminUser");
		String locator_pass = sfdclocator.getLocator("AdminPass");
		String locator_Submit = sfdclocator.getLocator("AdminLogin");
		String locator_Next = sfdclocator.getLocator("AdminNext");
		sendKeys(locator_uname, username);
		clickOn(locator_Next);
		waitForWorkAroundTime(3000);
		sendKeys(locator_pass, password);
		clickOn(locator_Submit);
	}

	//Login into the testing Sandbox for PMTH
	public void LoginInSFDC(String username, String password)
	{
		String locator_uname = sfdclocator.getLocator("Login");
		String locator_pass = sfdclocator.getLocator("Password");
		String locator_Submit = sfdclocator.getLocator("Submit");
		sendKeys(locator_uname, username);
		sendKeys(locator_pass, password);
		clickOn(locator_Submit);
	}
	
	//Login into Paypal Account
	public void LoginInPaypal(String username, String password)
	{
		String locator_uname = sfdclocator.getLocator("PLogin");
		String locator_Next = sfdclocator.getLocator("PNext");
		String locator_pass = sfdclocator.getLocator("PPassword");
		String locator_Submit = sfdclocator.getLocator("PSubmit");
		sendKeys(locator_uname, username);
		clickOn(locator_Next);
		waitForWorkAroundTime(8000);
		sendKeys(locator_pass, password);
		clickOn(locator_Submit);
		waitForWorkAroundTime(10000);
	}
	
	//Verify Page text
	public void VerifySFDCPageTitle(String value)
	{
		String locator =  "//li/span[contains(text() , '"+value+"')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 10);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify Payment type for cc
	public void VerifyPaymentType(String value)
	{
		String locator =  "//span[contains(text() , 'Credit Card')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify Payment type for paypal
	public void VerifyPaypalPaymentType(String value)
	{
		String locator =  "//span[contains(text() , 'PayPal')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify payment status
	public void VerifyPaymentStatus(String value)
	{
		String locator =  "//span/span[contains(text() , 'Authorized')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify payment status after capture
	public void VerifyCaptureStatus(String value)
	{
		String locator =  "//span/span[contains(text() , 'Completed')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify payment status after void
	public void VerifyVoidStatus(String value)
	{
		String locator =  "//span/span[contains(text() , 'Voided')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 30);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify payment status after refund
	public void VerifyRefundStatus(String value)
	{
		String locator =  "//span/span[contains(text() , 'Refunded')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 30);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify Transaction type
	public void VerifyTransactionType(String value)
	{
		String locator =  "//span/span[contains(text() , 'Authorization')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify Transaction type after Capture
	public void VerifyCaptureTransaction(String value)
	{
		String locator =  "//span/span[contains(text() , 'Payment')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify  Subtype
	public void VerifySubType(String value)
	{
		String locator =  "//span[contains(text() , 'Jyotish Service')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify  Payment Processor
	public void VerifyPaymentProcessor(String value)
	{
		String locator =  "//span[contains(text() , 'Authorize.net')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify  Payment Processor for Paypal
	public void VerifyPaypalProcessor(String value)
	{
		String locator =  "//span[contains(text() , 'PayPal')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify  Processor Connection
	public void VerifyProcessorConnection(String value)
	{
		String locator =  "//a[contains(text() , 'Authorize.net for Jyotish')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}

	//Verify  Processor Connection for Paypal
	public void VerifyPaypalProcessorConnection(String value)
	{
		String locator =  "//a[contains(text() , 'PayPal for Jyotish')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify Account
	public void VerifyLink(String value)
	{
		String locator =  "//a[@class='slds-input group-element-input uiOutputURL']";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify Account
	public void VerifyMessge(String value)
	{
		String locator =  "//*[contains(text() , '"+value+"')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
		}
	
	//Verify benefactor's Account
	public void VerifyBenefactorAccount(String value)
	{
		String locator =  "//*[@id='CF00NV00000016nQh_ileinner']";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	//Verify First Name
	public void VerifyFirstName(String value)
	{
		String locator =  "//*[@id='00NV00000016nQn_ileinner']";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//verify Last Name
	public void VerifyLastName(String value)
	{
		String locator =  "//*[@id='00NV00000016nQo_ileinner']";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify Email address
	public void VerifyEmail(String value)
	{
		String locator =  "//*[@id='00NV00000016nQm_ileinner']";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value.toLowerCase()), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify Phone number
	public void VerifyOrderNumber(WebElement value)
	{
		String locator =  "//*[contains(text() , '"+value+"')]";
		String Order = ""+value+"";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(Order), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	//Verify Application Status
	public void VerifyApplicationStatus(String value)
	{
		String locator =  "//*[@id='00No0000009sPgc_ileinner']";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	 //Verify Account Code
		public void VerifyAccountCode(String value)
		{
			String locator =  "//span/div/a[contains(text() , 'CBC-')]";
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			this.WaitForElementPresent(locator, 20);
			Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
		}
		
		
		//Verify Account Status for departed
		public void VerifyAccountStatus(String value)
		{
			String locator =  "//span[contains(text() , 'Departed')]";
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			this.WaitForElementPresent(locator, 20);
			Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
		}
		
		//Verify payment method
		public void VerifyPaymenMethod(String value)
		{
			String locator =  "//span[contains(text() , 'Complementary')]";
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			this.WaitForElementPresent(locator, 20);
			Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
		}
		
		//Verify payment method
		public void VerifyProductOveride(String value)
		{
		    String locator =  "//div[@id='00No000000DswEK_ileinner']";
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			this.WaitForElementPresent(locator, 20);
			Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
		}
		
		//Verify Total payment amount
		public void VerifyPaymenAmount(String value)
		{
			String locator =  "//div[@id='00No0000009sPge_ileinner']";
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			this.WaitForElementPresent(locator, 20);
			Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
		}
		
		//Verify payment title page
		public void VerifyPaymenPage(String value)
		{
			Assert.assertTrue(getWebDriver().getPageSource().contains(value), "Expected Text :" + value + " not Found.");
		}
	
	public void WaitForItem(String xml_node, int wait)
	{
		String locator = sfdclocator.getLocator(xml_node);
		WaitForElementPresent(locator, wait);
	}
	
	public void FillinData(String xmlnode, String value)
	{
		String locator = sfdclocator.getLocator(xmlnode);
		sendKeys(locator, value);
	}
	
	//select application in link builder
	public void Selectapplication(String value)
	{
		String application = sfdclocator.getLocator("LinkBuilder.SelectApplication");
		selectDropDown(application, value);
		waitForWorkAroundTime(300);
	}
	
	//Select by xml node and text
	public void SelectListItem(String xmlnode, String value)
	{
		String locator = sfdclocator.getLocator(xmlnode);
		selectDropDown(locator, value);
		waitForWorkAroundTime(2000);
	}
	
	// Store text from a locator2
	public String getText1(String xmlnode) {
		String locator = sfdclocator.getLocator(xmlnode);
	    WaitForElementPresent(xmlnode, 10);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
		String text = getWebDriver().findElement(ByLocator(locator)).getText();
		return text;
			}
	
	//click Xml node
		public void ClickItem(String xmlnode)
		{
			String locator = sfdclocator.getLocator(xmlnode);
			WaitForElementPresent(locator, 20);
			clickOn(locator);
			
		}
		
		//Double Click
		public void DoubleClick(String locator)
		{
			Actions builder = new Actions(getWebDriver());
			WebElement e1 = getWebDriver().findElement(ByLocator(locator));
			builder.doubleClick(e1).build().perform();
		}
		
		
	
		
}
