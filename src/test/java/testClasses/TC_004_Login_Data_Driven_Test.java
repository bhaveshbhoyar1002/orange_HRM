package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_004_Login_Data_Driven_Test extends BaseClass{
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)//because we dataproviders *in different package and class
	public void test_login_data_driven_test(String username, String password, String exp) throws InterruptedException
	{
		try {
		logger.info("******* Straing TC_004_Login_Data_Driven_Test********** ");
		LoginPage lp=new LoginPage (driver);
		lp.setUsername(username);
		lp.setpassword(password);
		lp.clklogin();
		Thread.sleep(3000);
		
		DashboardPage dp=new DashboardPage(driver);
		boolean Dashboardhead=dp.isDashboardExists();
		
		if(exp.equals("Valid"))
		{
			if(Dashboardhead==true)
			{
				dp.clkdrpdown();
				Thread.sleep(3000);
				dp.clklogout();
				Thread.sleep(3000);
				
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equals("Invalid"))
		{
			if(Dashboardhead==true)
			{
				dp.clkdrpdown();
				Thread.sleep(3000);
				dp.clklogout();
				Thread.sleep(3000);
				
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		} catch(Exception e) {
			Assert.fail();
		}
		logger.info("************Finished******************");
		}
	}

