package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.ForgetPasswordPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_003_Logout_Functionality extends BaseClass {
	
	@Test
	 void forget_password_test(){
		
		try {
			
			LoginPage lp=new LoginPage (driver);
			lp.setUsername(rb.getString("username"));
			lp.setpassword(rb.getString("password"));
			//lp.setpassword("Test123");
			lp.clklogin();
			Thread.sleep(3000);
			
			DashboardPage dp=new DashboardPage(driver);
			dp.clkdrpdown();
			
			boolean Dashboardhead=dp.isDashboardExists();
			Assert.assertEquals(Dashboardhead, true);
			System.out.println("Dashboard present");
			
			Thread.sleep(3000);
			dp.clklogout();
			Thread.sleep(3000);
			
		}
		catch(Exception e) {
			Assert.fail();
		}
		
	}

}
