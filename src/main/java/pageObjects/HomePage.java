package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	private WebDriver driver;
	public HeaderComponent loginWindow;
	
	public HomePage(WebDriver _driver) {
		
		this.driver = _driver;
		PageFactory.initElements(driver, this);
		
		String expectedTitle = "World business, finance, and political news from the Financial Times - FT.com";
		Assert.assertEquals(this.driver.getTitle(), expectedTitle);	
		
		this.loginWindow = new HeaderComponent(driver);
	}

}
