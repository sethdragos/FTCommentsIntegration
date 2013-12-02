package mainTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginComponent;
import utils.Constants;

public class MainTests {
	
	private WebDriver driver;

	@BeforeTest
	public void createDriver() {
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(Constants.WEBSITE);
	}

	@AfterTest
	public void tidyUp() {
		driver.quit();
	}

	@Parameters({ "valid_email", "valid_userid", "valid_pseudonym" })
	@Test (testName="Login")
	public void login() {
		//String email, String userid, String pseudonym
		HomePage homepage = new HomePage(driver);
		homepage.loginWindow.goToLoginComponent();
		
		LoginComponent login = new LoginComponent(driver);
		login.loginSuccess("user1100101@ft.com", "1100101", "user1100101@ft.com");
		
	}

}