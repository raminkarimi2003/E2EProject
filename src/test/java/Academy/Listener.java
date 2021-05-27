package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportTest;
import resources.base;


public class Listener extends base implements ITestListener{
	
	ExtentReports extent=ExtentReportTest.config();
	ExtentTest test;	
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>(); // Thread safe pool maintain tread safe for object of ExtentTest class
	@Override // and now extentTest object will store all 'test' object
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
       test=extent.createTest(result.getMethod().getMethodName());
       extentTest.set(test); //set the extentTest object to the created 'test' object from each test cases and send it to thread safe pool
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
     extentTest.get().log(Status.PASS, "Test Passed"); // get the extentTest object from the pool
	}
	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		extentTest.get().fail(result.getThrowable());  // get the extentTest object from the pool
		// TODO Auto-generated method stub
		String TestMethodName=result.getMethod().getMethodName();// get the method name where the failure occurred
		System.out.println("Method that is failing is "+TestMethodName);
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (Exception e) {
		
		}
		try {
			getScreenShot(TestMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // call the getScreenShot method with the Method name to be used as the failure name
	}
	
		
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override 
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();

	}

}
