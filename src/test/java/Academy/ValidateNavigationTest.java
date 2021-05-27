package Academy;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import resources.base;
@Listeners(Academy.Listener.class)
public class ValidateNavigationTest extends base {
	WebDriver driver;
	private static Logger log=LogManager.getLogger(ValidateNavigationTest.class.getName());
	@BeforeTest
	public void Initialize() throws IOException
	{
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
		log.debug("The driver is initialized");
		log.info("The url was succesfully recognized");
	}
	@Test
	public void baseNavigator() throws IOException
	{
		
		LandingPage lp=new LandingPage(driver);
		// assert if navigation bar is displayed or not
		Assert.assertTrue(lp.Menu().isDisplayed());
		log.info("The navigation is displayed");
	}
	 @AfterTest
	 public void teardown()
	 {
		 driver.close();
	 }
		
	}


