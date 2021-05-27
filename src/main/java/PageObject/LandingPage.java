package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


  
public class LandingPage {
  public WebDriver driver;

  public LandingPage(WebDriver driver) // constructor initialized with the driver from Home page and assigned to the local driver
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);	
  }
  
  By linkText=By.linkText("Login");
  By courses=By.cssSelector("div[class='text-center'] h2");
  By menuBar=By.cssSelector("ul[class='nav navbar-nav navbar-right'] li");
  
  public WebElement getLogin()
  {
	  return driver.findElement(linkText);
  }
  public WebElement FeaturedCourses()
  {
	  return driver.findElement(courses);
  }
  public WebElement Menu()
  {
	  return driver.findElement(menuBar);
  }
}
