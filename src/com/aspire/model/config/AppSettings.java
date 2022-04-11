package com.aspire.model.config;

public class AppSettings {
	
	public static final String appConfigFilePath= System.getProperty("user.dir")+"\\src\\config.json";
	
	private static String baseUrl;
	
	private static String userName;

	private static String password;
	
	private static String browser;
	
	private static String property;
	
	public static String getProperty() {
		return property;
	}

	public static void setProperty(Object object) {
		AppSettings.property = (String) object;
	}

	private static String driverPath;

	public static String getBaseUrl() {
		return baseUrl;
	}

	public static void setBaseUrl(Object baseUrl) {
		AppSettings.baseUrl = (String) baseUrl;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(Object userName) {
		AppSettings.userName = (String) userName;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(Object password) {
		AppSettings.password = (String) password;
	}

	public static String getBrowser() {
		return browser;
	}

	public static void setBrowser(Object browser) {
		AppSettings.browser = (String) browser;
	}

	public static String getDriverPath() {
		return driverPath;
	}

	public static void setDriverPath(Object driverPath) {
		AppSettings.driverPath = (String) driverPath;
	}
	
	
}
