package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepo.CheckoutPage;
import pageObjectRepo.PageObjManager;
import utilities.TestContextSetup;

public class CheckoutPageStepDefinition {

	WebDriver driver;
	String actPrdtNameHome;
	TestContextSetup testContextSetup;
	PageObjManager pom;
	CheckoutPage cop;

	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		cop = testContextSetup.pom.getCheckoutPageObj();
	}

	@When("User validates the product name")
	public void user_validates_the_product_name() {
		String prdtName = cop.getPrdtName();
		Assert.assertTrue(prdtName.contains(testContextSetup.actPrdtNameHome));
	}

	@When("User validates the Apply Promo Code button")
	public void user_validates_the_apply_promo_code_button() {
		Assert.assertTrue(cop.verifyPromoBtn());
	}

	@When("User places the order")
	public void user_places_the_order() {
		cop.clickPlaceOrderBtn();
	}

	@When("User selects {string} from Choose Country")
	public void user_selects_from_choose_country(String country) {
		cop.selectCountryDropDown(country);
	}

	@When("User accepts Terms & Conditions and clicks on Proceed")
	public void user_accepts_terms_conditions_and_clicks_on_proceed() {
		cop.clickAgree();
		cop.clickProceedBtn();
	}

	@Then("User validates successful order placed message")
	public void user_validates_successful_order_placed_message() throws InterruptedException {
		String successMsg = cop.getSuccessMsg();
		System.out.println(successMsg);
		Assert.assertTrue(successMsg.contains("Thank you, your order has been placed successfully"));
	}

}
