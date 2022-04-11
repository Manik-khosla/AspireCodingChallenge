package com.aspire.test;

import org.testng.annotations.Test;

import com.aspire.config.AppConfig;
import com.aspire.constants.Browsers;
import com.aspire.manager.DriverManager;
import com.aspire.model.config.AppSettings;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestBase {

	public DriverManager driverManager;

	/**
	 * Reading Config.json File Before Running Test
	 */
	@BeforeSuite
	public void beforeSuite() {
		AppConfig config = new AppConfig();
		config.readAppConfig();
		driverManager = new DriverManager(AppSettings.getProperty(), AppSettings.getDriverPath(),
				Browsers.valueOf(AppSettings.getBrowser()));
	}

	/**
	 * Closing WebDriver Session After All Tests Executed
	 */
	@AfterSuite
	public void afterSuite() {
		driverManager.getdriverInstance().quit();
	}

}
