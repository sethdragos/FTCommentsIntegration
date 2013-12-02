package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginComponent {
	
	private WebDriver driver;
	
	@FindBy (id = "ftLogin-box")
	private WebElement loginBox;
	
	@FindBy(id = "ftLogin-username")
	private WebElement EmailField;
	
	@FindBy(id = "ftLogin-password")
	private WebElement PasswordField;
		
	@FindBy(xpath = ".//*[@id='ftLogin-box']/form/fieldset[3]/p[1]/button")
	private WebElement SignInBtn;
	
	public LoginComponent(WebDriver _driver)
	{
		this.driver = _driver;
		PageFactory.initElements(driver, this);
		
		Assert.assertEquals(true, loginBox.isDisplayed());
		
	}
	
	private void executeLogin(String email, String password) {
		
		EmailField.sendKeys(email);
		PasswordField.sendKeys(password);
		SignInBtn.submit();	
	}
	
	public HomePage loginSuccess(String email, String password) {

		executeLogin(email, password);		
		return new HomePage(driver);
	}
	
	public IncorrectLoginPage loginFail(String email, String password) {
		
		executeLogin(email, password);
		return new IncorrectLoginPage(driver);
	}
	
}
