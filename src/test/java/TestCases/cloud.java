package TestCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import resources.base;

public class cloud extends base{

	@Test
	public void cloud() throws MalformedURLException, InterruptedException
	{
		String Url="https://venki560:7710d2f2-7873-4b68-aeab-732cfb3aeb2c@ondemand.us-west-1.saucelabs.com:443/wd/hub";
		ChromeOptions Options = new ChromeOptions();
		Options.setCapability("platformName", "Windows 8.1");
		Options.setCapability("browserVersion", "86.0");
		WebDriver driver = new RemoteWebDriver(new URL(Url),Options);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		
	}
	
}
