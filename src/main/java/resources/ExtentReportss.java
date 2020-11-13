package resources;

import java.io.FileInputStream;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportss {
public static ExtentReports extent;	
	public static ExtentReports extentReportss()
	{
		
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("SeleniumExam");
		reporter.config().setReportName("Venkatesh");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Automation");
		return extent;
	}

}
