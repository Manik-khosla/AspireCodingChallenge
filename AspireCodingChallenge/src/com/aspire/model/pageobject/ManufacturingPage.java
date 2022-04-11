package com.aspire.model.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	private WebElement newManufacturingOrderReference;
	
	@FindBy(xpath="//input[@id='o_field_input_210']")
	private WebElement productTextField;
	
	@FindBy(xpath ="//button[@title='Save record']")
	private WebElement saveManufacturingOrderButton;
	
	@FindBy(xpath ="//button[@title='Create record']")
	private WebElement createButton;
	
	@FindBy(xpath ="//span[text()='Confirm']")
	private WebElement confirmStatusButton;
	
	@FindBy(xpath="//div[@class='o_statusbar_buttons']/button[4]/span")
	private WebElement doneStatusButton;
	
	@FindBy(xpath="//span[text()='Ok']")
	private WebElement confirmationPopupButton;
	
	@FindBy(xpath="//button[@name='process']")
	private WebElement immediateProductionConfirmButton;
	
	@FindBy(xpath="//button[@title='Edit record']")
	private WebElement editButton;
	
	@FindBy(xpath="//a[text()='Manufacturing Orders']")
	private WebElement manufacturingHomePageLink;
	
	@FindBy(xpath="//i[@title='Remove']")
	private WebElement removeFilter;
	
	@FindBy(xpath="//div[@class='o_loading_indicator']")
	private WebElement loadingIndicator; 
	
	
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

	public WebElement getNewManufacturingOrderReference() {
		return newManufacturingOrderReference;
	}

	public WebElement getProductTextField() {
		return productTextField;
	}
	
	public void enterProductName(String productName){
		productTextField.sendKeys(productName);
		productTextField.click();
		productTextField.sendKeys(Keys.ENTER);
	}

	public WebElement getSaveManufacturingOrderButton() {
		return saveManufacturingOrderButton;
	}

	public WebElement getCreateButton() {
		return createButton;
	}

	public void setCreateButton(WebElement createButton) {
		this.createButton = createButton;
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

	public WebElement getLoadingIndicator() {
		return loadingIndicator;
	}
	
	public String getManufacturingState(String manufacturingRefernceNumber){
		String state = DriverManager.getdriverInstance().findElement(By.xpath("//td[text()='"+ manufacturingRefernceNumber + "']/parent::tr/td[11]/span")).getText();
		return state;
	}
	
	
}
