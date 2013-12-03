package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginComponentTestPage {
	
	private WebDriver driver;
	
	@FindBy (id = "ftLogin-box")
	private WebElement loginBox;
	
	@FindBy(id = "ftLogin-username")
	private WebElement EmailField;
	
	@FindBy(id = "ftLogin-userid")
	private WebElement UserIdField;
	
	@FindBy(id = "ftLogin-pseudonym")
	private WebElement PseudonymField;	
	
	// Try using CSS selectors because they are more likely not to change during the development prcess.
	// If you must use XPATH, something like "fieldset[4]/p[1]" is not very accurate because if someone
	// adds something (for example a paragraph) you could end up having fieldset[4]/p[1] replaced by 
	// an other element than you expect or your path could become invalid if case of deletion.
	@FindBy(xpath = ".//*[@id='ftLogin-box']/form/fieldset[4]/p[1]/button")
	private WebElement SubmitBtn;
	
	public LoginComponentTestPage(WebDriver _driver)
	{
		this.driver = _driver;
		PageFactory.initElements(driver, this);
		// Please have in mind that the signature of assertEquals method is:
		// static void assertEquals(boolean actual, boolean expected) {..}
		// Here you have your assert the other way around.
		Assert.assertEquals(true, loginBox.isDisplayed());
		// System.out.println()'s are bad practice in tests, especially in pieces of code that are 
		// being reused in multiple ones.
		System.out.println("debug: login-box is displayed");
		
	}
	
	private void executeLogin(String email, String userid, String pseudonym) {
		
		// Java's naming conventions: 
		// @see <a href="http://www.oracle.com/technetwork/java/javase/documentation/codeconventions-135099.html#367"/>
		EmailField.sendKeys(email);
		UserIdField.sendKeys(userid);
		PseudonymField.sendKeys(pseudonym);
		SubmitBtn.submit();
		System.out.println("debug: credentials SENT");	
	}
	
	public HomePage loginSuccess(String email, String userid, String pseudonym) {

		executeLogin(email, userid, pseudonym);		
		return new HomePage(driver);
	}
	
	public HomePage loginFail(String email, String userid, String pseudonym) {
		
		executeLogin(email, userid, pseudonym);
		
		String expectedTitle = "FT.com / Invitation / Incorrect login";
		Assert.assertEquals(this.driver.getTitle(), expectedTitle);
		
		return new HomePage(driver);
	}
	
}
