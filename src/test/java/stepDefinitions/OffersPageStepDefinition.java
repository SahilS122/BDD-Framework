package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjectRepo.OfferPage;
import utilities.TestContextSetup;

public class OffersPageStepDefinition {

	WebDriver driver;
	String actPrdtNameHome;
	String actPrdtNameOffers;
	TestContextSetup testContextSetup;
	OfferPage op;

	public OffersPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		op = testContextSetup.pom.getOfferPageObj();
	}

	@Then("^User search (.*) product exists in offers page$")
	public void user_validates_if_product_exists_in_offers_page(String prdtName) throws InterruptedException {

		op.openOfferPage();
		testContextSetup.rm.switchToChildWindow();
		op.searchPrdt(prdtName);
		Thread.sleep(2000);
		actPrdtNameOffers = op.getPrdtText();

	}

	@Then("User validates product name from home and offers page")
	public void user_validates_product_name_from_home_and_offers_page() {
		Assert.assertEquals(actPrdtNameOffers, testContextSetup.actPrdtNameHome);
	}

}
