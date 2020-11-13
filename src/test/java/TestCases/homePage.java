package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepo.homePageObject;
import resources.base;

public class homePage extends base {
	
	private static Logger log = LogManager.getLogger(homePage.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("url is successfully Launched");
	}
	
	@Test
	public void homePage()
	{
		homePageObject hpO=new homePageObject(driver);
		System.out.println(hpO.homeText().getText());
		Assert.assertEquals(hpO.homeText().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTINGs");
		log.info("home page text displayed is correct");
		Assert.assertEquals(hpO.signIn().getText(), "Login");
		log.info("sign text displayed is correct");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("browser is closed");
	}

}
