package TestCases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepo.homePageObject;
import pageObjectRepo.loginPageObj;
import resources.base;

public class parameterMySQlServer extends base {
	
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(loginPage.class.getName());
		@BeforeTest
		public void setUp() throws IOException
		{
			driver=initializeDriver();
			log.info("driver initialize successfully");
		}
		
		@Test
		public void paraSQLData() throws SQLException, InterruptedException
		{
			String host="localhost";
			String port="3306";
			String url = "jdbc:mysql://"+host+":"+port+"/SelReviseDB";
			Connection con = DriverManager.getConnection(url, "root", "root");
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery("select * from SelTable where user='Tester'");
			driver.get(prop.getProperty("url"));
			log.info("application is launhed successfully");
			while(rs.next())
			{
			
			homePageObject hpO = new homePageObject(driver);
			loginPageObj lpO = new loginPageObj(driver);
			hpO.signIn().click();
			log.info("click on login btn passed");
			lpO.emailId().sendKeys(rs.getString("user"));
			Thread.sleep(5000);
			log.info("username is entered passed");
			lpO.password().sendKeys(rs.getString("password"));
			log.info("password is entered passed");
			lpO.loginBtn().click();
			log.info("login button is clicked");
			}
		}
		
		
		@AfterTest
		public void tearDown()
		{
			driver.close();
			log.info("Browser is closed");
		}

}
