package pageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.ReusableMethods;

public class CheckoutPage {

	public WebDriver driver;
	private By prdtName = By.xpath("//table[@id='productCartTables']/tbody/tr/td[2]");
	private By applyPromoBtn = By.xpath("//button[@class='promoBtn']");
	private By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");
	private By selectCountry = By.xpath("//label[contains(text(),'Choose Country')]//following-sibling::div/select");
	private By agreeCheck = By.xpath("//input[@class='chkAgree']");
	private By proceedBtn = By.xpath("//button[text()='Proceed']");
	private By successMsg = By.xpath("//div[@class='wrapperTwo']/span");
	public ReusableMethods rm;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPrdtName() {
		return driver.findElement(prdtName).getText();
	}
	
	public Boolean verifyPromoBtn() {
		return driver.findElement(applyPromoBtn).isDisplayed();
	}
	
	public void clickPlaceOrderBtn() {
		driver.findElement(placeOrderBtn).click();;
	}
	
	public void selectCountryDropDown(String country) {
		rm = new ReusableMethods(driver);
		rm.waitForElementPresence(selectCountry);
		Select sel = new Select(driver.findElement(selectCountry));
		sel.selectByValue(country);
		
	}
	
	public void clickAgree() {
		driver.findElement(agreeCheck).click();
	}
	
	public void clickProceedBtn() {
		driver.findElement(proceedBtn).click();
	}
	
	public String getSuccessMsg() {
		return driver.findElement(successMsg).getText();
	}
}
