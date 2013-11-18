package utils;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {
	
	public WebDriver startBrowser(String browser)
			throws MalformedURLException {

		DesiredCapabilities capability = null;

		switch (browser) {
		case "firefox":
			System.out.println("firefox");
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(org.openqa.selenium.Platform.ANY);
			break;
		case "chrome":
			System.out.println("chrome");
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			break;
		case "ie":
			System.out.println("internet explorer");
			capability = DesiredCapabilities.internetExplorer();
			capability.setBrowserName("internet explorer");
			capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			break;
		case "safari":
			System.out.println("safari");
			capability = DesiredCapabilities.safari();
			capability.setBrowserName("safari");
			capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			break;
		}

		return new RemoteWebDriver(new URL(Constants.GRID_HUB), capability);
	}
}