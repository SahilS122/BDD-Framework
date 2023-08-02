package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjectRepo.PageObjManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String actPrdtNameHome;
	public PageObjManager pom;
	public WebDriverManager wdm;
	public ReusableMethods rm;
	
	public TestContextSetup() throws IOException {
		wdm = new WebDriverManager();
		pom = new PageObjManager(wdm.getDriver());
		rm = new ReusableMethods(wdm.getDriver());
	}
}
