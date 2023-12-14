package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")
    WebElement dashboardHeading;
	
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")
	WebElement clkdrpdown;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")
	WebElement clklogout;
	
	public boolean isDashboardExists(){
		try {
			return(dashboardHeading.isDisplayed());
					}
		catch(Exception e) {
			return (false);
		}
	}
	
	
	public void clkdrpdown() {
		// TODO Auto-generated method stub
		clkdrpdown.click();
	}
	public void clklogout() {
		// TODO Auto-generated method stub
		clklogout.click();
	}

	
	
	
}
