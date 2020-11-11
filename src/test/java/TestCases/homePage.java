package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepo.homePageObject;
import resources.base;

public class homePage extends base {
	
	public WebDriver driver;
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void homePage()
	{
		homePageObject hpO=new homePageObject(driver);
		System.out.println(hpO.homeText().getText());
		Assert.assertEquals(hpO.homeText().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		Assert.assertEquals(hpO.signIn().getText(), "Login");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
