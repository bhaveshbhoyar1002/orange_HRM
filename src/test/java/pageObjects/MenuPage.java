package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
	public MenuPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
	WebElement clkadmin;
	
	public void clklogin() {
		clkadmin.click();
		
	}
}
