package utilities;

import java.awt.Desktop;
import java.io.File;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener 
{
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	@Override
	public void onStart(ITestContext context)
	{
		
		String timeStamp=new SimpleDateFormat("YYYY.MM.DD.HH.mm.ss").format(new Date());
        repName="Test-Report-"+ timeStamp +".html"; 		
		sparkreporter=new ExtentSparkReporter(".\\reports\\"+repName);
		
		sparkreporter.config().setDocumentTitle("OrangeHRM Automation Report");
		sparkreporter.config().setReportName("OrangeHRM Functional Testing");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		extent.setSystemInfo("Application", "OrangeHRM");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customer");
		extent.setSystemInfo("userName", "shivaji");
		extent.setSystemInfo("Environment", "QA");
		
		String browser=context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String>IncludedGroups=context.getCurrentXmlTest().getIncludedGroups();
		if(!IncludedGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", IncludedGroups.toString());
		}

		
	}
	@Override
	public void onTestSuccess(ITestResult result) 
	{	
	   test=extent.createTest(result.getClass().getName());
	   test.assignCategory(result.getMethod().getGroups());
	   test.log(Status.PASS, result.getName()+"got successfully executed");
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName()+"got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
		   String imgPath=new BaseClass().capturescreen(result.getName());
		   test.addScreenCaptureFromPath(imgPath);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		   test=extent.createTest(result.getClass().getName());
		   test.assignCategory(result.getMethod().getGroups());
           test.log(Status.SKIP,result.getName()+"got skipped");
		   test.log(Status.INFO,result.getThrowable().getMessage());
		

	}
	@Override
	public void onFinish(ITestContext context)
	{
		
		extent.flush();
		
		String pathofExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport=new File(pathofExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
	}
	

}
