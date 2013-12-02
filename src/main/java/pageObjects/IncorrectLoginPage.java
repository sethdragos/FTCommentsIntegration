package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IncorrectLoginPage {
	
	private WebDriver driver;

	public IncorrectLoginPage(WebDriver _driver) {
		
		this.driver = _driver;
		PageFactory.initElements(driver, this);
		
		String expectedTitle = "FT.com / Invitation / Incorrect login";
		Assert.assertEquals(this.driver.getTitle(), expectedTitle);
		
	}

}