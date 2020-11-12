package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoPageObj {
	
	public WebDriver driver;
	public AutoPageObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Basic Auth')]")
	public WebElement autoClick;
	
	@FindBy(xpath="//p[contains(text(),'Congratulations')]")
	public WebElement autoText;

}
