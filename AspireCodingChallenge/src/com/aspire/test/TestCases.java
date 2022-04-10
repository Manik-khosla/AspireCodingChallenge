package com.aspire.test;

import org.testng.annotations.Test;

import com.aspire.model.config.AppSettings;
import com.aspire.model.pageobject.HomePage;
import com.aspire.model.pageobject.InventoryPage;
import com.aspire.model.pageobject.LoginPage;
import com.aspire.model.pageobject.ManufacturingPage;
import com.aspire.model.pageobject.ProductPage;
import com.aspire.utils.RandomNameGenerator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

public class TestCases extends TestBase{
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private InventoryPage inventoryPage;
	private ProductPage productPage;
	private ManufacturingPage manufacturingPage;
	private WebDriverWait wait;
	
	@BeforeClass
	public void setup(){
		driver = driverManager.getdriverInstance();
		driver.get(AppSettings.getBaseUrl());
		loginPage = new LoginPage(driverManager);
		homePage = new HomePage(driverManager);
		inventoryPage = new InventoryPage(driverManager);
		productPage = new ProductPage(driverManager);
		manufacturingPage = new ManufacturingPage(driverManager);
		wait = new WebDriverWait(driver, 15);
	}
	
	@Test(priority=0)
	public void login() {
		loginPage.EnterCredentials(AppSettings.getUserName(), AppSettings.getPassword());
		loginPage.clickButton(loginPage.getLoginButton());
		wait.until(ExpectedConditions.visibilityOf(homePage.getUser()));
		
	}
	
	@Test(priority=1)
	public void navigateToInventory() {
		homePage.goToInventory();
		wait.until(ExpectedConditions.visibilityOf(inventoryPage.getInventoryHeading()));	
	}
	
	@Test(priority=2)
	public void createNewProduct()
	{
		inventoryPage.clickButton(inventoryPage.getProductsTab());
		WebElement product = wait.until(ExpectedConditions.visibilityOf(inventoryPage.getProducts()));
		inventoryPage.clickButton(product);
		WebElement createProduct = wait.until(ExpectedConditions.visibilityOf(productPage.getCreateNewProductButton()));
		productPage.clickButton(createProduct);
		WebElement products = wait.until(ExpectedConditions.visibilityOf(productPage.getProductNameTextField()));
		productPage.enterProductname(RandomNameGenerator.generateRandomString());
		productPage.clickButton(productPage.getSaveProductButton());
		wait.until(ExpectedConditions.visibilityOf(productPage.getActionButton()));
	}
	
	@Test(priority=3)
	@Parameters("quantity")
	public void updateProductQuantity(int quantity){
		WebElement updateQuantityButton = wait.until(ExpectedConditions.visibilityOf(productPage.getUpdateQuantityButton()));
		productPage.clickButton(updateQuantityButton);
		WebElement createStockButton = wait.until(ExpectedConditions.visibilityOf(productPage.getCreateStockButton()));
		productPage.clickButton(createStockButton);
	    WebElement saveButton = wait.until(ExpectedConditions.visibilityOf(productPage.getSaveProductButton()));
	    productPage.getInventoryQuantityTextField().clear();
	    productPage.updateProductQuantity(quantity);
	    productPage.clickButton(saveButton);
	}
	
	@Test(priority=4)
	public void navigateToHomePage(){
		homePage.goToHomePage();
		wait.until(ExpectedConditions.visibilityOf(homePage.getInventory()));
	}
	
	@Test(priority=5)
	public void createManufacturingOrder(){
		homePage.clickButton(homePage.getManufacturing());
		wait.until(ExpectedConditions.visibilityOf(manufacturingPage.getManufacturingOrderHeading()));
		manufacturingPage.clickButton(manufacturingPage.getCreateNewManufacturingOrderButton());
		wait.until(ExpectedConditions.visibilityOf(manufacturingPage.getNewManufacturingOrderHeading()));
		manufacturingPage.enterProductName(RandomNameGenerator.getRandomProductName());
		manufacturingPage.selectProductNameFromDropDown();
		manufacturingPage.clickButton(manufacturingPage.getSaveManufacturingOrderButton());
	}
	
	@Test(priority=6)
	public void updateManufacturingOrderStatus(){
		
		manufacturingPage.clickButton(manufacturingPage.getConfirmStatusButton());
		WebElement doneStatusButton = wait.until(ExpectedConditions.visibilityOf(manufacturingPage.getDoneStatusButton()));
		manufacturingPage.clickButton(doneStatusButton);
		WebElement confirmationButton = wait.until(ExpectedConditions.visibilityOf(manufacturingPage.getConfirmationPopupButton()));
		manufacturingPage.clickButton(confirmationButton);
		WebElement immediateProductionConfirmButton = wait.until(ExpectedConditions.visibilityOf(manufacturingPage.getImmediateProductionConfirmButton()));
		manufacturingPage.clickButton(immediateProductionConfirmButton);
		wait.until(ExpectedConditions.visibilityOf(manufacturingPage.getEditButton()));
		manufacturingPage.manufacturingReferenceNumber = manufacturingPage.getManufacturingOrderHeading().getText();
	}
	
	@Test(priority=7)
	public void validateOrderDetails()
	{
		manufacturingPage.clickButton(manufacturingPage.getManufacturingHomePageLink());
		wait.until(ExpectedConditions.visibilityOf(manufacturingPage.getManufacturingOrderHeading()));
		manufacturingPage.clickButton(manufacturingPage.getRemoveFilter());
		
		
	}

}
