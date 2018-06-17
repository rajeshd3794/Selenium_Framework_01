package com.rajesh.testBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.rajesh.report.ExtentReport1;
import com.rajesh.utility.AppConfig;
import com.relevantcodes.extentreports.LogStatus;

public class TestEnvironment1 {
	@BeforeClass(alwaysRun=true)
	public void setUp() throws Exception
	{
		System.out.println("*****************************************************");
		System.out.println("launching Browser");
		TestBase.getBrowser(AppConfig.getBrowser());
		//TestBase.getApk(AppConfig.getApkPathLocation());
		//WaitHelper.setImplicitWait(50);
		//WaitHelper.setPageLoadTimeout(50);
	}
	
	@BeforeTest
	public void testStart() throws IOException
	{			   
		ExtentReport1.extent.addSystemInfo("Project Name","Rajesh Selenium Web  Project");
		ExtentReport1.extent.addSystemInfo("Time Zone", System.getProperty("user.timezone"));
		ExtentReport1.extent.addSystemInfo("User Location", System.getProperty("user.country"));
		ExtentReport1.extent.addSystemInfo("OS version", System.getProperty("os.version"));
		ExtentReport1.extent.addSystemInfo("Java Version", System.getProperty("java.version"));
		
		ExtentReport1.extent.loadConfig(new File(AppConfig.getExtent_ConfigXML()));
	}
	
	@BeforeMethod
	public static void beforeMethod(Method result)
	{
		ExtentReport1.test=ExtentReport1.extent.startTest(result.getName());
		ExtentReport1.test.log(LogStatus.INFO,result.getName()+" Test has Started");
	}
	
	@AfterMethod
	public static void afterMethod(ITestResult result) throws IOException
	{
		ExtentReport1 report = new ExtentReport1();
		report.getResult(result);
	}
	
	@AfterTest
	public void testResult()
	{
		ExtentReport1.extent.endTest(ExtentReport1.test);
		ExtentReport1.extent.flush();	
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() throws Exception
	{
		if(TestBase.driver!=null)
				{
					System.out.println("Closing the Browser");
					System.out.println("*****************************************************");
					//TestBase.driver.close();
					TestBase.driver.quit();
				}
	}

}
