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
	
	//@FindBy(css = "css=p.ftLogin-rememberMe > button.standardImage")
	@FindBy(xpath = ".//*[@id='ftLogin-box']/form/fieldset[4]/p[1]/button")
	private WebElement SubmitBtn;
	
	public TestPage(WebDriver _driver)
	{
		this.driver = _driver;
		PageFactory.initElements(driver, this);
		
		String expectedTitle = "Livefyre test page - FT.com";
		Assert.assertEquals(this.driver.getTitle(), expectedTitle);
		System.out.println("Debug msg: Title OK");		
	}
	
	private void executeLogin(String email, String userid, String pseudonym) {
		
		SignInBtn.click();
		EmailField.sendKeys(email);
		UserIdField.sendKeys(userid);
		PseudonymField.sendKeys(pseudonym);
		SubmitBtn.click();
		System.out.println("Debug msg: Credentials SENT");	
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
