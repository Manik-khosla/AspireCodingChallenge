package com.aspire.model.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.manager.DriverManager;

public class HomePage extends BasePage{
	
	private DriverManager manager;
	
	@FindBy(xpath="//a[@title='Home menu']")
	private WebElement homePageLink;
	
	@FindBy(xpath= "//span[text() = 'User']")
	private WebElement user;

	@FindBy(xpath = "//div[text()='Inventory']")
	private WebElement inventory;

	@FindBy(xpath = "//div[text() = 'Manufacturing']")
	private WebElement manufacturing;
	
	@FindBy(xpath="//a[text() = 'Log out']")
	private WebElement logoutButton;

	public HomePage(DriverManager manager){
		this.manager = manager;
		PageFactory.initElements(manager.getdriverInstance(), this);
	}
	
	public WebElement getInventory() {
		return inventory;
	}

	public WebElement getManufacturing() {
		return manufacturing;
	}
	
	public WebElement getUser() {
		return user;
	}
	
	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public void goToInventory(){
		this.clickButton(inventory);
	}
	
	public void goToManufacturing(){
		this.clickButton(manufacturing);
	}
	
	public void goToHomePage(){
		this.clickButton(homePageLink);
	}

}
