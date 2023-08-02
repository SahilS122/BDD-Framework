package utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {

	WebDriver driver;

	public ReusableMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToChildWindow() {
		Set<String> winHandles = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winHandles);
//		String parentWin = winList.get(0);
		String childWin = winList.get(1);
		driver.switchTo().window(childWin);
	}
	
	public void waitForElementPresence(By ele) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		wt.until(ExpectedConditions.presenceOfElementLocated(ele));
	}
}
