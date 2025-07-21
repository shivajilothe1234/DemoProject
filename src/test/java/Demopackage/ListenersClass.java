package Demopackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener {
	
	
	
	
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test execution is started......");
	}


	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test started");	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is passed...."+result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is Failed...."+result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is skipped..."+result.getName());

	}

	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
		System.out.println("Test execution Finished");

	}
	
	

}
