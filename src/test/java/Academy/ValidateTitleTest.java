package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.base;
import PageObject.LandingPage;
@Listeners(Academy.Listener.class)
public class ValidateTitleTest extends base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(ValidateTitleTest.class.getName());
    @Test
	public void CompareTitle() throws IOException
	{
		LandingPage fc=new LandingPage(driver);
		String courses=fc.FeaturedCourses().getText();
		Assert.assertEquals(courses, "FEATURED COURSES1");
        log.error("The course cannot be validated");

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
