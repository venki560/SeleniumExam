package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepo.AutoPageObj;
import resources.base;

public class AutoITPage extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(AutoITPage.class.getName());
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=initializeDriver();
		log.info("driver initialized");
	}
	
	@Test
	public void authWin() throws InterruptedException
	{
		AutoPageObj auto = new AutoPageObj(driver);
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		log.info("the-internet page is launched");
		auto.autoClick.click();
		Thread.sleep(5000);
		log.info("auth windows is cleared successfully");
		Assert.assertEquals(auto.autoText.getText(), "Congratulations! You must have the proper credentials.");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
