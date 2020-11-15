package TestCases;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectRepo.homePageObject;
import pageObjectRepo.loginPageObj;
import resources.base;
import resources.excelDataDriven;

public class excelDataLoginPage extends base {
public WebDriver driver;
private static Logger log = LogManager.getLogger(excelDataLoginPage.class.getName());
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=initializeDriver();
		log.info("driver initialize successfully");
	}
	
	@Test
	public void login() throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		log.info("application is launhed successfully");
		homePageObject hpO = new homePageObject(driver);
		loginPageObj lpO = new loginPageObj(driver);
		excelDataDriven excel = new excelDataDriven();
		ArrayList data = excel.getExcelData("Login");
		hpO.signIn().click();
		log.info("click on login btn passed");
		lpO.emailId().sendKeys("data.get(0)");
		log.info("username is entered passed");
		lpO.password().sendKeys("data.get(1)");
		log.info("password is entered passed");
		lpO.loginBtn().click();
		log.info("login button is clicked");
	}
	
	
	
	

	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("Browser is closed");
	}
	
	
	
}
