package com.rajesh.homePage;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rajesh.report.ExtentReport;
import com.rajesh.testBase.TestBase;
import com.rajesh.testBase.TestEnvironment;
import com.rajesh.utility.AppConfig;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyContactForm_CurrentURL extends TestEnvironment
{
	//public static ExtentTest test;

	
		/*@BeforeMethod
		public static void beforeMethod(Method result)
		{
			ExtentReport.test=ExtentReport.extent.startTest(result.getName());
			ExtentReport.test.log(LogStatus.INFO,result.getName()+" Test has Started");
		}*/
	
	 @Test
	  public void CurrentPageURLValidation() throws Exception 
	  {	  
	  TestBase.loadPropertiesFile();
	  ExtentReport.test.log(LogStatus.INFO, "url opened");
	  TestBase.driver.navigate().to(AppConfig.getMyContactURL());
	  Assert.assertEquals(TestBase.driver.getCurrentUrl(), "https://www.mycontactform.com/");
	  }
	 
	 /*@AfterMethod
		public static void afterMethod(ITestResult result) throws IOException
		{
			ExtentReport report = new ExtentReport();
			report.getResult(result);
		}*/
}
