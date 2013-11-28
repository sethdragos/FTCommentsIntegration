package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginComponent {
	
	private final WebDriver driver;
	
	@FindBy (id = "ftLogin-box")
	private WebElement loginBox;
	
	@FindBy(id = "ftLogin-username")
	private WebElement EmailField;
	
	@FindBy(id = "ftLogin-userid")
	private WebElement UserIdField;
	
	@FindBy(id = "ftLogin-pseudonym")
	private WebElement PseudonymField;	
	
	@FindBy(xpath = ".//*[@id='ftLogin-box']/form/fieldset[4]/p[1]/button")
	private WebElement SubmitBtn;
	
	public LoginComponent(WebDriver _driver)
	{
		this.driver = _driver;
		PageFactory.initElements(driver, this);
		
		Assert.assertEquals(true, loginBox.isDisplayed());	
		System.out.println("debug: login-box is displayed");
	}
	
	private void executeLogin(String email, String userid, String pseudonym) {
		
		EmailField.sendKeys(email);
		UserIdField.sendKeys(userid);
		PseudonymField.sendKeys(pseudonym);
		SubmitBtn.submit();
		System.out.println("Debug msg: Credentials SENT");	
	}
	
	public HomePage loginSuccess(String email, String userid, String pseudonym) {

		executeLogin(email, userid, pseudonym);		
		return new HomePage(driver);
	}
	
	public HomePage loginFail(String email, String userid, String pseudonym) {
		
		executeLogin(email, userid, pseudonym);
		
		return new HomePage(driver);
	}
	
}
