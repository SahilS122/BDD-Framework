package pageObjectRepo;

import org.openqa.selenium.WebDriver;

public class PageObjManager {
	
	public HomePage homePageObj;
	public OfferPage offerPageObj;
	public CheckoutPage checkoutPageObj;
	public WebDriver driver;
	
	public PageObjManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePageObj() {
		homePageObj = new HomePage(driver);
		return homePageObj;
	}
	
	public OfferPage getOfferPageObj() {
		offerPageObj = new OfferPage(driver);
		return offerPageObj;
	}
	
	public CheckoutPage getCheckoutPageObj() {
		checkoutPageObj = new CheckoutPage(driver);
		return checkoutPageObj;
	}
}
