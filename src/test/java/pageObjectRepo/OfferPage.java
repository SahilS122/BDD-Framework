package pageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ReusableMethods;

public class OfferPage {
	
	public WebDriver driver;
	private By offerPageLink = By.linkText("Top Deals");
	private By searchPrdt = By.xpath("//input[@type='search']");
	private By prdtText = By.xpath("//table/tbody/tr/td");
	public ReusableMethods rm;
	
	public OfferPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openOfferPage() {
		driver.findElement(offerPageLink).click();
	}
	
	public void searchPrdt(String prdtName) {
		rm = new ReusableMethods(driver);
		rm.waitForElementPresence(searchPrdt);
		driver.findElement(searchPrdt).sendKeys(prdtName);
	}
	
	public String getPrdtText() {
		return driver.findElement(prdtText).getText();
	}
	
}
