package com.aspire.model.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.manager.DriverManager;

public class ProductPage extends BasePage{
	private DriverManager manager;
	
	@FindBy(xpath ="//button[@title='Create record']")
	private WebElement createNewProductButton;
	
	@FindBy(xpath ="//input[@placeholder='e.g. Cheese Burger']")
	private WebElement productNameTextField;
	
	@FindBy(xpath ="//button[@title='Save record']")
	private WebElement saveProductButton;
	
	@FindBy(xpath="//span[text()='Action']")
	private WebElement actionButton;
	
	@FindBy(xpath="//span[text()='Update Quantity']")
	private WebElement updateQuantityButton;
	
	@FindBy(xpath="//button[@data-original-title='Create record']")
	private WebElement createStockButton;
	
	@FindBy(xpath ="//input[@name='inventory_quantity']")
	private WebElement inventoryQuantityTextField;
	
	public ProductPage(DriverManager manager){
		this.manager = manager;
		PageFactory.initElements(manager.getdriverInstance(), this);
	}

	public WebElement getCreateNewProductButton() {
		return createNewProductButton;
	}
	
	public void enterProductname(String productName){
		this.productNameTextField.sendKeys(productName);
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSaveProductButton() {
		return saveProductButton;
	}
	
	public WebElement getActionButton() {
		return actionButton;
	}

	public WebElement getUpdateQuantityButton() {
		return updateQuantityButton;
	}
	
	public WebElement getCreateStockButton() {
		return createStockButton;
	}

	public WebElement getInventoryQuantityTextField() {
		return inventoryQuantityTextField;
	}
	
	public void updateProductQuantity(int quantity){
		inventoryQuantityTextField.sendKeys(Integer.toString(quantity));
	}
	
	
	
}
