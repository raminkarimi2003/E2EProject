package resources;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class base {
	
	/**
	 * @throws IOException
	 */
	public WebDriver driver;
	public Properties prop;
	public WebDriver InitializeDriver() throws IOException {
		prop=new Properties(); // using property class to read from a file
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fs);
		String browser=prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\driverResources\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("MSEdge"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\driverResources\\msedgedriver.exe");
			 driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver; // send the driver back to be used 
	}

	public String getURL()
	{
		String url=prop.getProperty("url");
		return url;
		
	}
	public void getScreenShot(String MethodName, WebDriver driver) throws IOException
	{ 
		TakesScreenshot sh=(TakesScreenshot) driver; // driver is the field of the class for the method and is responsible for taking the screenshot by the help of TakeScreeshot interface and store it
		File source=sh.getScreenshotAs(OutputType.FILE); // take screenshot of file put it in system
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\Reports\\"+MethodName+".png")); // copy snapshot in the system to new file created at root level
	} 
	
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
	FileUtils.copyFile(source,new File(destinationFile));

	return destinationFile;
	}
	
}
