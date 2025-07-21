package Demopackage;

import java.time.Duration;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Demopackage.ListenersClass.class)

public class DataProviderDemo {
	
	 public WebDriver driver;
	 
	 @Parameters ({  "browser" })
	 @BeforeClass
	  public void setup(String br)
	 {
		  switch(br)
		  {
		    case "chrome" :driver=new ChromeDriver();break; 
		    case "firefox":driver=new FirefoxDriver();break;
		    case "edge"   :driver=new EdgeDriver();break; 
		    
		    default: System.out.println("invalid browser");
		  } 
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.manage().deleteAllCookies();
		    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 }
	 

	@Test(dataProvider="dp")
	public void TestLogin(String name,String pass) throws InterruptedException
	{
	   try {
	   driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(name);
	   driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
	   driver.findElement(By.xpath("//button[@type='submit']")).click();
	   }
	   catch(Exception e)
	   {
		   e.getMessage();   }
	   try {
	   boolean status=driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).isDisplayed();
	   Thread.sleep(5000);
	   if(status==false)
	   {
		   driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		   Actions act=new Actions(driver);
		   WebElement ele=driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
		   act.moveToElement(ele).click();
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   Assert.fail();
	   }
	   }
	   catch(Exception e)
	   {
		   e.getMessage();
	   }
	   
	}
	@AfterClass
	void teardown()
	{
		driver.close();
	}
	@DataProvider(name="dp")
	Object[][]loginData()
	{
		Object data[][]= {
				             {"Admin","admin1234"},
				             {"Admi","admin123"},
				             {"Admin","admin123"}
				
		                 };
		return data;
	}
	

}
