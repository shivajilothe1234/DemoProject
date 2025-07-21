package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

/* public class TC001_LoginDDT extends BaseClass
{
	
	 
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups={"sanity"})
    public void verify_loginDDT(String username,String password,String exp)
    {
		  try
		  {
			  
	        LoginPage lp=new LoginPage(driver);
	        
    	    lp.setuserName(username);
       	    lp.setpasstxt(password);
    	    lp.ClkOnloginbtn();
    	    
    	
    	  HomePage hp=new HomePage(driver);
    	  boolean targetPage=hp.isDashboardPageExists();
    	
    	  if(exp.equalsIgnoreCase("valid"))
    	  {
    		  if(targetPage==true)
    		  {

    			hp.ClkOnLogout();
                Assert.assertTrue(true);

              }
    		  else
    		  {
    			Assert.assertTrue(false);
    	      }
    		
    	}
    	if(exp.equalsIgnoreCase("invalid"))
    	{
    		if(targetPage==true)
    		{
                hp.ClkOnLogout();
		        Assert.assertTrue(false);

    		}   
    	    else
    	    {
    		   Assert.assertTrue(true);
    	    }
    	 
        }
		  }
    	catch(Exception e)
    	{
    	    
    	}
    } 
	
	
 }*/
    	 
 
		
		
    	
		
	
	
    	
