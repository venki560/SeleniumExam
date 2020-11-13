package TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepo.AutoPageObj;
import pageObjectRepo.uploadPage;
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
	
	@Test
	public void uploadDownload() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("urlUpload"));
		Thread.sleep(5000);
		uploadPage upDown = new uploadPage(driver);
		upDown.chooseFile.click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec(rootPath+"//src//main//java//resources//autoItScript1.exe");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'9.46 KB')]")));
		Assert.assertEquals(upDown.KB.getText(), "9.46 KB");
		upDown.download.click();
		Thread.sleep(10000);
		File s = new File(rootPath+"/wordFile-converted.pdf");
		if(s.exists())
		{
			Assert.assertTrue(s.exists());
			{
				if(s.delete())
				{
					System.out.println("file deleted");
					log.info("file deleted");
				}
			}
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
