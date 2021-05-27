package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import resources.base;

public class ValidateMenueBarTest extends base {
	public static Logger log=LogManager.getLogger(ValidateMenueBarTest.class.getName());
	@Test
	public void MenuBar() throws IOException
	{
	 
	   LandingPage lp=new LandingPage(driver);
	   Assert.assertTrue(lp.Menu().isDisplayed());
	   log.info("The Menu is validated to be correct");
	}
	
	 @BeforeTest
	 public void Initialize() throws IOException
	    {
	    	driver=InitializeDriver();
			driver.get(getURL()); // call the property method from the base , since the base is already inherited
	    }
	
	 @AfterTest
	 public void teardown()
	   {
		   driver.close();
	   }
}
