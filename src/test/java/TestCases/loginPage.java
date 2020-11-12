package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectRepo.homePageObject;
import pageObjectRepo.loginPageObj;
import resources.base;

public class loginPage extends base {
public WebDriver driver;
private static Logger log = LogManager.getLogger(loginPage.class.getName());
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=initializeDriver();
		log.info("driver initialize successfully");
	}
	
	@Test(dataProvider="getData")
	public void login(String username, String password)
	{
		driver.get(prop.getProperty("url"));
		log.info("application is launhed successfully");
		homePageObject hpO = new homePageObject(driver);
		loginPageObj lpO = new loginPageObj(driver);
		hpO.signIn().click();
		log.info("click on login btn passed");
		lpO.emailId().sendKeys(username);
		log.info("username is entered passed");
		lpO.password().sendKeys(password);
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
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0]="adminOne";
		data[0][1]="adminOne";
		data[1][0]="adminTwo";
		data[1][1]="adminTwo";
		return data;
		
	}
	
	
}
