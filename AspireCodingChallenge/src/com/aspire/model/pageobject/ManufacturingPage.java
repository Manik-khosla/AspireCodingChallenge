package com.aspire.model.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.manager.DriverManager;

public class ManufacturingPage extends BasePage{
	
	private DriverManager manager;
	
	public static String manufacturingReferenceNumber;
	
	@FindBy(xpath="//span[text()='Manufacturing Orders']")
	private WebElement manufacturingOrderHeading;
	
	@FindBy(xpath="//button[@data-original-title='Create record']")
	private WebElement createNewManufacturingOrderButton;
	
	@FindBy(xpath="//span[@placeholder='Manufacturing Reference']")
	private WebElement newManufacturingOrderHeading;
	
	@FindBy(xpath="//input[@id='o_field_input_210']")
	private WebElement productTextField;
	
	@FindBy(xpath ="//button[@title='Save record']")
	private WebElement saveManufacturingOrderButton;
	
	@FindBy(xpath ="//list[@class='ui-menu-item']/a")
	private WebElement listDropdown;
	
	@FindBy(xpath ="//span[text()='Confirm']")
	private WebElement confirmStatusButton;
	
	@FindBy(xpath="//button[@name='button_mark_done']")
	private WebElement doneStatusButton;
	
	@FindBy(xpath="//span[text()='Ok']")
	private WebElement confirmationPopupButton;
	
	@FindBy(xpath="//button[@name='process']")
	private WebElement immediateProductionConfirmButton;
	
	@FindBy(xpath="//button[@title='Edit record']")
	private WebElement editButton;
	
	@FindBy(xpath="//a[text()='Manufacturing Orders'")
	private WebElement manufacturingHomePageLink;
	
	@FindBy(xpath="//i[@title='Remove']")
	private WebElement removeFilter;
	
	
	public ManufacturingPage(DriverManager manager){
		this.manager = manager;
		PageFactory.initElements(manager.getdriverInstance(), this);
	}

	public WebElement getManufacturingOrderHeading() {
		return manufacturingOrderHeading;
	}

	public WebElement getCreateNewManufacturingOrderButton() {
		return createNewManufacturingOrderButton;
	}

	public WebElement getNewManufacturingOrderHeading() {
		return newManufacturingOrderHeading;
	}

	public WebElement getProductTextField() {
		return productTextField;
	}
	
	public void enterProductName(String productName){
		this.productTextField.sendKeys(productName);
	}
	
	public void selectProductNameFromDropDown(){
		this.listDropdown.click();
	}

	public WebElement getSaveManufacturingOrderButton() {
		return saveManufacturingOrderButton;
	}

	public WebElement getConfirmStatusButton() {
		return confirmStatusButton;
	}

	public WebElement getDoneStatusButton() {
		return doneStatusButton;
	}

	public WebElement getConfirmationPopupButton() {
		return confirmationPopupButton;
	}

	public WebElement getImmediateProductionConfirmButton() {
		return immediateProductionConfirmButton;
	}

	public static String getManufacturingReferenceNumber() {
		return manufacturingReferenceNumber;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getManufacturingHomePageLink() {
		return manufacturingHomePageLink;
	}

	public WebElement getRemoveFilter() {
		return removeFilter;
	}
	
	
	
	
	
	
	
	
}
