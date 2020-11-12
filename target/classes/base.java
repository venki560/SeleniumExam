package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class base {

	public WebDriver driver;
	public Properties prop;
	@Test
	public WebDriver initializeDriver() throws IOException
	{
		String rootPath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(rootPath+"\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
		String browserTypee = prop.getProperty("Browser");
		String browserType = System.getProperty("Browser");
		if(browserTypee.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", rootPath+"\\src\\main\\java\\resources\\chromedriver86.exe");
			driver = new ChromeDriver();
		}
		else if(browserTypee.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rootPath+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
		
	}
	
	
}

