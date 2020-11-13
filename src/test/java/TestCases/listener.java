package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportss;
import resources.base;

public class listener extends base implements ITestListener{
public WebDriver driver;
ExtentReports extent = ExtentReportss.extentReportss();
ExtentTest ext;
ThreadLocal<ExtentTest> extTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ext = extent.createTest(result.getMethod().getMethodName());
		extTest.set(ext);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extTest.get().log(Status.PASS, "Script Passed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extTest.get().fail(result.getThrowable());
		String userMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) 
		{
		}	
		
		try {
			extTest.get().addScreenCaptureFromPath(getScreenShot(userMethodName,driver), result.getMethod().getMethodName());
		//	getScreenShot(userMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
