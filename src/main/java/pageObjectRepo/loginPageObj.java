package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageObj {
public WebDriver driver;

	public loginPageObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='user_email']")
	private WebElement emailId;
	
	@FindBy(xpath="//input[@id='user_password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement loginBtn;
	
	
	
	public WebElement emailId()
	{
		return emailId;
	}
	
	public WebElement password()
	{
		return password;
	}
	
	public WebElement loginBtn()
	{
		return loginBtn;
	}
	
}
