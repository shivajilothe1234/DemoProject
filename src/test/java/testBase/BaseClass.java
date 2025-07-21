

package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass
{
	
	
   public static WebDriver driver;
   public Properties p;
   
	@BeforeClass(groups={"sanity"})	
	@Parameters({"browser"})
	public void setup(String br) throws IOException
	{
		try
		{
		    FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\DemoProject\\src\\test\\resources\\config.properties");
	     	p=new Properties();
            p.load(file);
		 }
		 catch(Exception e)
		 {
			e.getMessage();
		 }
		  switch(br.toLowerCase())
		  {
		    
		   // case "edge"   :driver=new EdgeDriver();break;
            case "chrome" :driver=new ChromeDriver();break;
		    //case "firefox":driver=new FirefoxDriver();break;
		    default:System.out.println("invalid browser name");
		  }
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.manage().deleteAllCookies();
		  driver.get(p.getProperty("appUrl"));
	}
		
		public String capturescreen(String tname)
		{
			String timeStamp=new SimpleDateFormat("YYYY.MM.DD.HH.mm.ss").format(new Date());
            
			TakesScreenshot takescreenshot=(TakesScreenshot)driver;
			File sourceFile=takescreenshot.getScreenshotAs(OutputType.FILE);
			String targetFilepath=System.getProperty("user.dir")+"\\screenshots\\"+tname+" "+timeStamp+".png";
			File targetFile=new File(targetFilepath);
			sourceFile.renameTo(targetFile);
			return targetFilepath;
		}
	
	
     
	@AfterClass(groups={"sanity"})
	public void tearDown()
	{
		driver.quit();
	}

	
}
