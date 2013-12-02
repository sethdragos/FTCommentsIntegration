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
		System.out.println("debug: webdriver initialized OK");
	}

	@AfterTest
	public void tidyUp() {
		driver.quit();
		System.out.println("debug: webdriver shutdown OK");
	}

	@Parameters({ "valid_email", "valid_userid", "valid_pseudonym" })
	@Test
	public void validLogin(String email, String userid, String pseudonym) {
		
		HomePage homepage = new HomePage(driver);
		homepage.loginWindow.goToLoginComponent();
		
		LoginComponent login = new LoginComponent(driver);
		login.loginSuccess(email, userid, pseudonym);
		
	}
	
	@Parameters({ "invalid_email", "invalid_userid", "invalid_pseudonym" })
	@Test
	public void invalidLogin(String email, String userid, String pseudonym) {
		
		//TODO incorrect flow while using JWT-App.herokuapp.com, should refactor after switching to FT.com
		
		HomePage homepage = new HomePage(driver);
		homepage.loginWindow.goToLoginComponent();
		
		LoginComponent login = new LoginComponent(driver);
		login.loginSuccess(email, userid, pseudonym);
		
	}

}