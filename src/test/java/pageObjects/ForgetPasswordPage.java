package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPasswordPage extends BasePage {

	public ForgetPasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "username")
	WebElement txtusername;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/div/form/div[2]/button[2]")
	WebElement resetpswd;
	
	public void setusername(String password) {
		txtusername.sendKeys(password);
	}
	public void resetpassword() {
		resetpswd.click();
	}
}
