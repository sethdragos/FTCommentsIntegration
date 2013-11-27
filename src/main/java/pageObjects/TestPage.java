package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestPage {
	
	private final WebDriver driver;
	
	@FindBy(id = "ftLogin-signIn")
	private WebElement SignInBtn;
	
	@FindBy(id = "ftLogin-username")
	private WebElement EmailField;
	
	@FindBy(id = "ftLogin-userid")
	private WebElement UserIdField;
	
	@FindBy(id = "ftLogin-pseudonym")
	private WebElement PseudonymField;	
	
	@FindBy(css = "css=p.ftLogin-rememberMe > button.standardImage")
	private WebElement SubmitButton;
	
	public TestPage(WebDriver _driver)
	{
		this.driver = _driver;
		PageFactory.initElements(driver, this);
		
		String expectedTitle = "Livefyre test page - FT.com";
		Assert.assertEquals(this.driver.getTitle(), expectedTitle);
		
	}
	
	private void executeLogin(String email, String userid, String pseudonym) {
		
		EmailField.sendKeys(email);
		UserIdField.sendKeys(userid);
		PseudonymField.sendKeys(pseudonym);
		SignInBtn.submit();
	}
	
	public TestPage loginSuccess(String email, String userid, String pseudonym) {

		executeLogin(email, userid, pseudonym);		
		return new TestPage(driver);
	}
	
	public TestPage loginFail(String email, String userid, String pseudonym) {
		
		executeLogin(email, userid, pseudonym);
		
		return new TestPage(driver);
	}
	
}
