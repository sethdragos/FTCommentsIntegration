package mainTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HeaderComponent;
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

	@Parameters({ "valid_email", "valid_password" })
	@Test
	public void validLogin(String email, String password) {
		
		HomePage homepage = new HomePage(driver);
		homepage.loginWindow.goToLoginComponent();
		
		LoginComponent signin = new LoginComponent(driver);
		signin.loginSuccess(email, password);
		
		HeaderComponent signout = new HeaderComponent(driver);
		signout.logOut();
	
	}
	
	@Parameters({ "invalid_email", "invalid_password" })
	@Test
	public void invalidLogin(String email, String password) {
		
		HomePage homepage = new HomePage(driver);
		homepage.loginWindow.goToLoginComponent();
		
		LoginComponent login = new LoginComponent(driver);
		login.loginFail(email, password);
		
	}
	
	@Test
	public void betaFeatures() {
		
		
	}

}