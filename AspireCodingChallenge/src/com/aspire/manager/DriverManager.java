package com.aspire.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.AppCacheStatus;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aspire.constants.Browsers;
import com.aspire.model.config.AppSettings;

public class DriverManager {
	
	private static WebDriver driver;
	private String browserName;
	
	public DriverManager(String key, String executablePath, Browsers browser) {
		System.setProperty(key, executablePath);

		switch (browser) {
		case CHROME:
			driver = new ChromeDriver();
			this.browserName = Browsers.CHROME.toString();
			break;
		case EDGE:
			driver = new EdgeDriver();
			this.browserName = Browsers.EDGE.toString();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			this.browserName = Browsers.FIREFOX.toString();
			break;
		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver();
			this.browserName = Browsers.INTERNETEXPLORER.toString();
			break;
		case SAFARI:
			driver = new SafariDriver();
			this.browserName = Browsers.SAFARI.toString();
			break;
		}
		// maximizing browser window
		driver.manage().window().maximize();

	}
	
	public static WebDriver getdriverInstance() {
		if (driver == null) {
			new DriverManager(AppSettings.getProperty(), AppSettings.getDriverPath(),Browsers.valueOf(AppSettings.getBrowser()));
			return driver;
		} else {
			return driver;
		}
	}

}
