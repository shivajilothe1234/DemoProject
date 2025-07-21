package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class SimpleDemo extends BaseClass{
	
	@Test(groups="sanity")
	public void verify_Logo()
	{
		try {
		LoginPage lp=new LoginPage(driver);
	  boolean b1=lp.islogoDisplayed();
	  if(b1==true)
	  {
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  Assert.assertFalse(false);
	  }
	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		e.getMessage();
	}
	
		
	}	
}


