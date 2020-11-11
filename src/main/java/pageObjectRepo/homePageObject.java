package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePageObject {

	public WebDriver driver;
	public homePageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[contains(text(),'An Academy to learn Everything about Testing')]")
	private WebElement homeText;
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	private WebElement signInBtn;
	
	
	public WebElement homeText()
	{
		return homeText;
	}
	
	public WebElement signIn()
	{
		return signInBtn;
	}
	
}
