package pageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	public WebDriver driver;
	private By searchPrdt = By.xpath("//input[@type='search']");
	private By prdtText = By.xpath("//h4[@class='product-name']");
	private By increaseQuantity = By.xpath("//a[@class='increment']");
	private By addToCartBtn = By.xpath("//div[@class='product-action']/button[@type='button']");
	private By cartBtn = By.xpath("//a[@class='cart-icon']/img");
	private By proccedToCheckoutBtn = By.xpath("//div[contains(@class,'cart-preview')]//button");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchPrdt(String prdtName) {
		driver.findElement(searchPrdt).sendKeys(prdtName);
	}
	
	public String getPrdtText() {
		return driver.findElement(prdtText).getText();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void addQuantity(int quantity) {
		for(int i=1;i<quantity;i++) {
			driver.findElement(increaseQuantity).click();
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCartBtn).click();
	}
	
	public void viewCart() {
		driver.findElement(cartBtn).click();
	}
	
	public void proceedToCheckout() {
		driver.findElement(proccedToCheckoutBtn).click();
	}
}
