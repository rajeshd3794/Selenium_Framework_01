package com.rajesh.homePage;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rajesh.testBase.TestBase;
import com.rajesh.testBase.TestEnvironment;
import com.rajesh.testData.ExcelReader;
import com.rajesh.utility.AppConfig;

public class MyContactForm_SIgnUp extends TestEnvironment
{
	@DataProvider(name="MyContatcForm Registration data")
	public Object[][] passData() throws IOException
	{
		return ExcelReader.getExcelData(AppConfig.getExcelPath1(), "Sheet1");
	}
	
	
	@Test(dataProvider = "MyContatcForm Registration data")
	public void userSingUp(String user1,String email,String User2, String MycontactPassword, String RetypePassword) throws Exception
	{ 
		TestBase.loadPropertiesFile();
		TestBase.driver.navigate().to(AppConfig.getMyContactURL());
		Thread.sleep(2000);
	    
		WebElement register1 = TestBase.getWebElement("SignupButton");		
	    JavascriptExecutor js = (JavascriptExecutor)TestBase.driver;
		js.executeScript("arguments[0].setAttribute('target','_self');",register1);
	    register1.click(); 
	    
	    
	    TestBase.getWebElement("Name").sendKeys(user1);
	    TestBase.getWebElement("email").sendKeys(email);
	    TestBase.getWebElement("UserName").sendKeys(User2);

	    TestBase.getWebElement("MycontactPassword").sendKeys(MycontactPassword);
	    TestBase.getWebElement("RetypePassword").sendKeys(RetypePassword);
	    TestBase.getWebElement("Checkbox").click();
	    TestBase.getWebElement("MyContactSubmitButton").click();
	    
	    Thread.sleep(2000);
	}

}
