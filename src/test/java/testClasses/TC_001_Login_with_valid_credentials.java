package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MenuPage;
import testBase.BaseClass;

public class TC_001_Login_with_valid_credentials extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	 void test_login_with_valid_credentials()
	{
		logger.debug("********************** application****************");
		logger.info("******************Starting Login Testcase*********************");
		
		try {
		LoginPage lp=new LoginPage (driver);
		
		lp.setUsername(rb.getString("username"));
		//lp.setUsername("Admin");
		logger.info("******************Enter Username*********************");
		Thread.sleep(3000);
		
		lp.setpassword(rb.getString("password"));
		//lp.setpassword("admin123");
		logger.info("******************Enter Password*********************");
		Thread.sleep(3000);
		
		lp.clklogin();
		logger.info("******************Click on Login*********************");
		Thread.sleep(3000);
		
		MenuPage mp=new MenuPage (driver);
	    mp.clklogin();
	    Thread.sleep(5000);
		}
		
		catch(Exception e) {
			Assert.fail();
		}
		
		
		logger.info("******************finished testcase*********************");
	}

}