package resources;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTest {
	public static ExtentReports extent;
	@Test
	public static ExtentReports config() {

		String ExtentReportPath=System.getProperty("user.dir")+"\\Reports\\Index.html";
		ExtentSparkReporter Reporter=new ExtentSparkReporter(ExtentReportPath);
		Reporter.config().setDocumentTitle("ExtentReport");
		Reporter.config().setReportName("Test Report");
		extent=new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("Tester", "Ramin Karimi");
		return extent;
	}

}
