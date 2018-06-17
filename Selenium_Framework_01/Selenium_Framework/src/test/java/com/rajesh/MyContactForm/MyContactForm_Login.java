package com.rajesh.MyContactForm;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rajesh.report.ExtentReport;
import com.rajesh.report.ExtentReport1;
import com.rajesh.testBase.TestBase;
import com.rajesh.testBase.TestEnvironment;
import com.rajesh.testBase.TestEnvironment1;
import com.rajesh.testData.ExcelReader;
import com.rajesh.utility.AppConfig;
import com.relevantcodes.extentreports.LogStatus;

public class MyContactForm_Login extends TestEnvironment1
	{
		@DataProvider(name="MyContatcForm Registration data")
		public Object[][] passData() throws IOException
		{
			return ExcelReader.getExcelData(AppConfig.getExcelPath2(), "logindt");
		}
		
		
		@Test(dataProvider = "MyContatcForm Registration data")
		public void userlogin(String usern,String pasw) throws Exception
		{ 
			TestBase.loadPropertiesFile();
			TestBase.driver.navigate().to(AppConfig.getMyContactURL());
			ExtentReport1.test.log(LogStatus.INFO, "myContactForm url opened");
			Thread.sleep(2000);
		    TestBase.getWebElement("username").sendKeys(usern);
			 ExtentReport1.test.log(LogStatus.INFO, "username entered");

		    TestBase.getWebElement("loginpasw").sendKeys(pasw);
			ExtentReport1.test.log(LogStatus.INFO, "password entered");

		    TestBase.getWebElement("loginbtn").click();
			ExtentReport1.test.log(LogStatus.INFO, "login button clicked");

		    Thread.sleep(2000);
		}


}
