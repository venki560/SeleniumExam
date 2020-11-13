package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class uploadPage {
	
	public WebDriver driver;
	public uploadPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Choose Files')]")
	public WebElement chooseFile;
	
	@FindBy(xpath="//span[contains(text(),'wordFile-converted.pdf')]")
	public WebElement wordFile;
	
	@FindBy(xpath="//span[contains(text(),'Download')]")
	public WebElement download;
}

