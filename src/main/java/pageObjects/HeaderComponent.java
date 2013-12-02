package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HeaderComponent {

	private WebDriver driver;
	
	@FindBy (id = "header")
	private WebElement headerElement;
	
	@FindBy(id = "ftLogin-signIn")
	private WebElement SignInBtn;
	
	@FindBy (id = "ftLogin-logout")
	private WebElement SignOutBtn;
	
	public HeaderComponent(WebDriver _driver) {
	
		this.driver = _driver;
		PageFactory.initElements(driver, this);
		
		Assert.assertEquals(true, headerElement.isDisplayed());	
	}
	
	public LoginComponent goToLoginComponent() {
		
		this.SignInBtn.click();
		return new LoginComponent(driver);
	}
	
	public HomePage logOut() {
		
		this.SignOutBtn.click();		
		return new HomePage(driver);
	}
	
}
