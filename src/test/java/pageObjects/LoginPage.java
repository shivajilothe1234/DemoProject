package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	       
		/*@FindBy(xpath="//img[@alt='company-branding']")
		WebElement OrangeHRMLogo;
    	@FindBy(xpath="//input[@placeholder='Username']")
	    WebElement usernametxt;
    	@FindBy(xpath="//input[@placeholder='Password']")
    	WebElement passwordtxt;
    	@FindBy(xpath="//button[@type='submit']")
    	WebElement clkloginbtn;
    	
    	public boolean isorangehrmlogoExist()
    	{
    		return(OrangeHRMLogo.isDisplayed());
    	}
    	public void setuserName(String un)
    	{
    		usernametxt.sendKeys(un);      }
        public void setpasstxt(String pwd)
        {
        	passwordtxt.sendKeys(pwd);
        }
        public void ClkOnloginbtn()
        {
        	clkloginbtn.click();
        }*/
	
	   @FindBy(xpath="//img[@alt='company-branding']")
	   WebElement logo;
	   
	   public boolean islogoDisplayed()
	   {
		   boolean b=logo.isDisplayed();
		   return b;
	   }
	
}
        
       
                	
        	
        
        	 
        	
        	
        	
             	
        

		
        
        
     
  
