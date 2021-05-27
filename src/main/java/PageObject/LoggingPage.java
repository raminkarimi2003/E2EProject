package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoggingPage {
	public WebDriver driver;
	
	public LoggingPage(WebDriver driver)
	{
	 this.driver=driver;
	  PageFactory.initElements(driver, this);	
	}
  By email=By.cssSelector("input[name='email']");
  By password=By.id("user_password");
  By submit=By.xpath("//input[@type='submit']");
  
  public WebElement Email()
  {
	  return driver.findElement(email);
  }
  public WebElement Password()
  {
	  return driver.findElement(password);
  }
  public WebElement Submit()
  {
	  return driver.findElement(submit);
  }
}
