package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utilities.TestContextSetup;

public class Hooks {
	
	WebDriver driver;
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@After
	public void closeBrowser() throws IOException {
		testContextSetup.wdm.getDriver().quit();
	}
	
	@AfterStep
	public void onTestFailAddSS(Scenario scenario) throws WebDriverException, IOException {
		if(scenario.isFailed()) {
			File src = ((TakesScreenshot)testContextSetup.wdm.getDriver()).getScreenshotAs(OutputType.FILE);
			byte[] imgBytes = FileUtils.readFileToByteArray(src);
			scenario.attach(imgBytes, "image/png", "images");
		}
	}
}
