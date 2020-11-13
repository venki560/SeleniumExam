package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class base {

	public WebDriver driver;
	public Properties prop;
	public String rootPath;
	public WebDriverWait wait;
	@Test
	public WebDriver initializeDriver() throws IOException
	{
		rootPath = System.getProperty("user.dir");
		HashMap<String,Object> perfsOpt = new HashMap<String, Object>();
		perfsOpt.put("profile.default_content_settings.popups", 0);
		perfsOpt.put("download.default_directory", rootPath);
		FileInputStream fis = new FileInputStream(rootPath+"\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
		String browserTypee = prop.getProperty("Browser");
		String browserType = System.getProperty("Browser");
		if(browserTypee.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", rootPath+"\\src\\main\\java\\resources\\chromedriver86.exe");
			ChromeOptions option= new ChromeOptions();
			option.setExperimentalOption("prefs", perfsOpt);
			if(browserType.contains("headless"))
			{
			option.addArguments("headless");
			}
			driver = new ChromeDriver(option);	
			
		}
		else if(browserTypee.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rootPath+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20); 
		return driver;
		
	}
	
	public String getScreenShot(String TestMethodName, WebDriver driver) throws IOException
	{
		TakesScreenshot sT=(TakesScreenshot)driver;
		File source = sT.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\report\\"+TestMethodName+".png";
		FileUtils.copyFile(source, new File(dest));
		return dest;
	}
	
}

