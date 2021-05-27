package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LoggingPage;
import resources.base;

@Listeners(Academy.Listener.class)
public class HomePageTest extends base {
	WebDriver driver;
	public static Logger log=LogManager.getLogger(HomePageTest.class.getName());
	@Test(dataProvider="getData")
	public void validateLogin(String username, String password) throws IOException
	{
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("driver is activated");
	    LandingPage lp=new LandingPage(driver);
		lp.getLogin().click();
		LoggingPage lg=new LoggingPage(driver);
		Assert.assertTrue(lg.Email().isEnabled());
		lg.Email().sendKeys(username);
		log.debug("The email is succefully enabled");
		lg.Password().sendKeys(password);
		lg.Submit().click();
	}
	
	@BeforeMethod
	public void Initialize() throws IOException
	{
		
	}
	
		@DataProvider
		public Object[][] getData()
		{   // running the test twice feeding 2 separate data by the help of Data provider
			// row stands for how many types of data test should run with
			// column stand for how many values the test should run with
			Object[][] data=new Object[2][2]; // create object data from DataProvider class
			//0th row 
			data[0][0]="RistrictedDataRamin_karimi@yahoo.ca";
			data[0][1]="password";
			
			// 1st row
			data[1][0]="NonRestictedDataRaminkarimi2003@yahoo.ca";
			data[1][1]="password";
			return data;
		}
		
		@AfterMethod
		public void teardown()
		{
			driver.close();
				
		}
}	



