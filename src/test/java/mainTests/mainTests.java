package mainTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

	@Test (testName="VerifyPageTitle")
	public void VerifyPageTitle() {
		
		String expectedTitle = "Livefyre test page - FT.com";
		Assert.assertEquals(this.driver.getTitle(), expectedTitle);
		
	}

}