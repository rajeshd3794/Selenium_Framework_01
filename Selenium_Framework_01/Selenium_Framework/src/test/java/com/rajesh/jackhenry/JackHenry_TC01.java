package com.rajesh.jackhenry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rajesh.report.ExtentReport;
import com.rajesh.testBase.TestBase;
import com.rajesh.testBase.TestEnvironment;
import com.rajesh.utility.AppConfig;
import com.relevantcodes.extentreports.LogStatus;

public class JackHenry_TC01 extends TestEnvironment
{
	 @Test
	    public void JackHenry_Events() throws Exception
	    {  
		  
		  TestBase.loadPropertiesFile();
		  //TestBase.driver.navigate().to(AppConfig.getApkPathLocation());
		  ExtentReport.test.log(LogStatus.INFO, "JackHenry APk file launched");
		  TestBase.driver.findElement(By.id("com.crowdcompass.appMx7vK0N1vS:id/action_search")).click();
		  ExtentReport.test.log(LogStatus.INFO, "Events button clicked");
		  WebElement text = TestBase.driver.findElement(By.xpath("//android.widget.TextView[@text='Search for events by event name, or by event password for private events.' and @index='0']"));
		  ExtentReport.test.log(LogStatus.INFO, "Events title identified");
		  Assert.assertEquals(text.getText(), "Search for events by event name, or by event password for private events.");
	        
	    }

}
