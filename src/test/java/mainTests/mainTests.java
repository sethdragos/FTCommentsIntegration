package mainTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.TestPage;
import utils.Constants;

public class mainTests {
	
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
	public void VerifyPageTitle(String email, String userid, String pseudonym) {
		
		TestPage login = new TestPage(driver);
		login.loginSuccess(email, userid, pseudonym);
		
	}

}