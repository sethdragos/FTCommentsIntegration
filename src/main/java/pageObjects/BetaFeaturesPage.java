package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BetaFeaturesPage {
	
	private WebDriver driver;
	
	@FindBy (xpath = ".//*[@id='beta-features-dashboard']/div/div/div[1]/div/div/div/div/a[1]")
	private WebElement BetaFeatureOptInBtn;
	
	@FindBy (xpath = ".//*[@id='beta-features-dashboard']/div/div/div[1]/div/div/div/div/a[2]")
	private WebElement BetaFeatureOptOutBtn;
	
	@FindBy (xpath = ".//*[@id='beta-features-dashboard']/div/div/div[2]/div/div/div[1]/div/div/a[1]")
	private WebElement LiveFyreOptInBtn;
	
	@FindBy (xpath = ".//*[@id='beta-features-dashboard']/div/div/div[2]/div/div/div[1]/div/div/a[2]")
	private WebElement LiveFyreOptOutBtn;
	
	@FindBy (xpath = ".//*[@id='beta-features-dashboard']/div/div/div[2]/div/div/div[2]/div/div/a[1]")
	private WebElement LiveFyreAutoLoginOptInBtn;
	
	@FindBy (xpath = ".//*[@id='beta-features-dashboard']/div/div/div[2]/div/div/div[2]/div/div/a[2]")
	private WebElement LiveFyreAutoLoginOptOutBtn;
	
	public BetaFeaturesPage(WebDriver _driver) {
		
		this.driver = _driver;
		PageFactory.initElements(driver, this);
		
		String expectedTitle = "Internal beta features";
		Assert.assertEquals(this.driver.getTitle(), expectedTitle);
		
	}
	
	public BetaFeaturesPage BetaFeaturesOptIn() {
		
		this.BetaFeatureOptInBtn.click();		
		return new BetaFeaturesPage(driver);
		
	}
	
	public BetaFeaturesPage BetaFeaturesOptOut() {
		
		this.BetaFeatureOptOutBtn.click();		
		return new BetaFeaturesPage(driver);
		
	}
	
	public BetaFeaturesPage LiveFyreOptIn() {
		
		this.LiveFyreOptInBtn.click();		
		return new BetaFeaturesPage(driver);
		
	}
	
	public BetaFeaturesPage LiveFyreOptOut() {
		
		this.LiveFyreOptOutBtn.click();		
		return new BetaFeaturesPage(driver);
		
	}
	
	public BetaFeaturesPage LiveFyreAutoLoginOptIn() {
		
		this.LiveFyreAutoLoginOptInBtn.click();		
		return new BetaFeaturesPage(driver);
		
	}
	
	public BetaFeaturesPage LiveFyreAutoLoginOptOut() {
		
		this.LiveFyreAutoLoginOptOutBtn.click();		
		return new BetaFeaturesPage(driver);
		
	}

}
