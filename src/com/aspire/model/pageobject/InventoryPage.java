package com.aspire.model.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.manager.DriverManager;

public class InventoryPage extends BasePage {
	private DriverManager manager;

	@FindBy(xpath = "//a[text()='Inventory']")
	private WebElement inventoryHeading;

	@FindBy(xpath = "//button[@title = 'Products']")
	private WebElement ProductsTab;

	@FindBy(xpath = "//a[@href='#menu_id=124&action=215']")
	private WebElement Products;

	public InventoryPage(DriverManager manager) {
		this.manager = manager;
		PageFactory.initElements(manager.getdriverInstance(), this);
	}

	public WebElement getInventoryHeading() {
		return inventoryHeading;
	}

	public WebElement getProductsTab() {
		return ProductsTab;
	}

	public WebElement getProducts() {
		return Products;
	}

}
