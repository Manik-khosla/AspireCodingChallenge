package com.aspire.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.aspire.model.config.AppSettings;

public class AppConfig {
    
	/**
	 *  Read App Configuration from Config.json File And setting Properties for Running Test Suite
	 */
	public void readAppConfig() {
		JSONParser parser = new JSONParser();
		try {
			JSONObject config = (JSONObject) parser.parse(new FileReader(AppSettings.appConfigFilePath));
			AppSettings.setBaseUrl(config.get("base_url"));
			AppSettings.setUserName(config.get("username"));
			AppSettings.setPassword(config.get("password"));
			AppSettings.setProperty(config.get("property"));
			AppSettings.setBrowser(config.get("browser"));
			AppSettings.setDriverPath(config.get("driver_path"));
		} catch (FileNotFoundException e) {
			System.out.println("Config.json File was not found at specified path");
		} catch (IOException e) {
			System.out.println("An Error occured while reading file." + e.getMessage());
		} catch (ParseException e) {
			System.out.println("An Error occured while reading file.Please check the file content. " + e.getMessage());
		}
	}
}
