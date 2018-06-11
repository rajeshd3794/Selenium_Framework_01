package com.rajesh.homePage;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.rajesh.testBase.TestBase;
import com.rajesh.testBase.TestEnvironment;
import com.rajesh.utility.AppConfig;

public class HomePage_01_Validation extends TestEnvironment
{
  @Test
  public void homePageValidation() throws Exception 
  {	  
	  TestBase.loadPropertiesFile();
	  TestBase.driver.navigate().to(AppConfig.getURL());
	  
	  WebElement logo = TestBase.getWebElement("HomePageLogo");
	  WebElement findflight = TestBase.getWebElement("FindAFlight");
	  
	  if(logo.isDisplayed()&& findflight.isEnabled())
	  {	
		  System.out.println(findflight.getAttribute("alt"));
		  System.out.println(logo.getAttribute("alt"));
	  }
  }
}
