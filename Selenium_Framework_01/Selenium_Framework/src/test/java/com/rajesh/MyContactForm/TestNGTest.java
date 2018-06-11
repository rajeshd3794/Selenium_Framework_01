package com.rajesh.MyContactForm;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNGTest 
{
	@Test
	public void Firstmethod()
	{
		System.out.println("First");
	}
	
	@Test
	public void Secondmethod() 
	{
		String a = "Rajesh";
		
		if(!a.equals("Rajesh"))
			throw new SkipException("Not Matched");
		else
			System.out.println("matched");
			
	}

}
