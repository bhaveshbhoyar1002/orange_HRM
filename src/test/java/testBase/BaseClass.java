package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;









public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	
	@BeforeClass(groups= {"Master","Regression","Sanity"})
	@Parameters ("browser")
	public void setup(String br)
	{
		        logger=LogManager.getLogger(this.getClass());
		        rb=ResourceBundle.getBundle("config");
		 
			  //WebDriverManager.edgedriver().setup();    
				//driver=new EdgeDriver(options);
				
			
		
		        
		   if(br.equals("edge")) {
			   EdgeOptions options=new EdgeOptions();
				options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--guest");
		        	driver=new EdgeDriver(options);
		        	System.out.println("edge");
		        }
		        else if(br.equals("chrome")) {
		        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhavesh.bhoyar\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		        	driver=new ChromeDriver();
		        	System.out.println("chrome");
		        }
		        else {
		        	driver=new FirefoxDriver();
		        }
		        
		        	
		        	
	       driver.manage().deleteAllCookies();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	       driver.get(rb.getString("appURL"));
	      // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	       driver.manage().window().maximize();
	
   }
		      
				
		
	
	/*	ChromeOptions options=new ChromeOptions();
				options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
				options.addArguments("--remote-allow-origins=*");
				
				WebDriverManger.chromedriver().setup();
				driver=new ChromeDriver(options);
				
				
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				
				driver.manage().window().maximize(); */
		        
		        
		        
		      
	
	@AfterClass(groups= {"Master","Regression","Sanity"})
	public void teardown()
	{
		driver.quit();
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	


}
