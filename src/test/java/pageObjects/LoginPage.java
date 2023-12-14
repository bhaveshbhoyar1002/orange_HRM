package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(name = "username")
	WebElement txtusername;
	
	@FindBy(name = "password")
	WebElement txtpassword;
		
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
		WebElement clicklogin;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")
	WebElement clickforgetlink;
	
	public void setUsername(String username) {
		txtusername.sendKeys(username);
		}
	public void setpassword(String password) {
		txtpassword.sendKeys(password);
	}
	public void clklogin() {
		clicklogin.click();
	}
		
	public void clickforgetlink() {
		clickforgetlink.click();
		
		
	}
	
	


	
}
