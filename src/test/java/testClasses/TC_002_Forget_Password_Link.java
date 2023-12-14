package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgetPasswordPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Forget_Password_Link extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	 void forget_password_test(){
		
		try {
			
			logger.info("******************Starting Login Testcase*********************");
			LoginPage lp=new LoginPage (driver);
			lp.clickforgetlink();
			Thread.sleep(3000);
			lp.setUsername(rb.getString("username"));
			Thread.sleep(3000);
			 ForgetPasswordPage fpp=new ForgetPasswordPage(driver);
			 fpp.resetpassword();
			 Thread.sleep(5000);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
	}

}
