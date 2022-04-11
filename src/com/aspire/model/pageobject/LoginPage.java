package com.aspire.model.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.manager.DriverManager;

public class LoginPage extends BasePage{
	private DriverManager manager;
	
	@FindBy(xpath="//input[@id='login']")
	private WebElement emailTextField;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement loginButton;
	
	public LoginPage(DriverManager manager){
		this.manager = manager;
		PageFactory.initElements(manager.getdriverInstance(), this);
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void EnterCredentials(String username, String password){
		emailTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
	}

}
