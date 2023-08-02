package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjectRepo.HomePage;
import pageObjectRepo.PageObjManager;
import utilities.TestContextSetup;

public class HomePageStepDefinition {

	WebDriver driver;
	String actPrdtNameHome;
	String actPrdtNameOffers;
	TestContextSetup testContextSetup;
	PageObjManager pom;
	HomePage hp;

	public HomePageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		hp = testContextSetup.pom.getHomePageObj();
	}

	@Given("User is on GreenKart home page")
	public void user_is_on_green_kart_home_page() {
		Assert.assertEquals(hp.getPageTitle(), "GreenKart - veg and fruits kart");
	}

	@When("^User search the product (.*)$")
	public void user_search_the_product(String prdtName) {
		hp.searchPrdt(prdtName);
	}

	@When("User gets the actual product name")
	public void user_gets_the_actual_product_name() throws InterruptedException {
		Thread.sleep(2000);
		testContextSetup.actPrdtNameHome = hp.getPrdtText().split("-")[0].trim();
		System.out.println(testContextSetup.actPrdtNameHome);
	}
	
	@When("^User add quantity (.+) for the product$")
	public void user_add_quantity_product_quantity_for_the_product(String quantity) {
		int qauntInt = Integer.parseInt(quantity);
		System.out.println(qauntInt);
		hp.addQuantity(qauntInt);
		hp.addToCart();
	}

	@When("User navigates to checkout page")
	public void user_navigates_to_checkout_page() throws InterruptedException {
		hp.viewCart();
		Thread.sleep(2000);
		hp.proceedToCheckout();
	}

}
