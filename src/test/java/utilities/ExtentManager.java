package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;
//import testBase.BaseClass;

public class ExtentManager {
	 WebDriver driver;
	public static ExtentReports reports;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	File file;
	static String  repName;
	protected static String screenshotPath ;
	
	@BeforeTest
    public static void setupReports() {
		test = reports.createTest("TEST");
		test.assignAuthor("author");
		//test.assignDevice(device);
		test.assignCategory("Automation");
		try {
			spark.loadXMLConfig("C:\\Users\\hi\\eclipse-workspace\\modularFramework\\extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 }
	@BeforeSuite
	public static void extent() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-"+ timeStamp+ ".html";
		spark = new ExtentSparkReporter(".\\reports\\"+ repName);
		spark.config().setDocumentTitle("Automation report");
		spark.config().setReportName("testing");
		spark.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(spark);
	    reports.setSystemInfo("Application", "SwagLabs application");
	    reports.setSystemInfo("Module", "Admin");
	    reports.setSystemInfo("Sub module", "customers");
	   }
	@AfterMethod
	public void checkStatus(Method m,ITestResult result) throws InterruptedException {
		if(result.getStatus() == ITestResult.FAILURE) {
		//	String screenshotPath = null;
			screenshotPath =BaseClass.CaptureScreen(result.getTestContext().getName()+"_"+result.getMethod().getMethodName());
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.fail(result.getThrowable());
			}
	  if(result.getStatus() == ITestResult.SUCCESS) {
			test.pass(m.getName() +" is passed");
		//	String screenshotPath = null;   //result.getTestContext().getName()+"_"+result.getMethod().getMethodName()
			screenshotPath = BaseClass.CaptureScreen(result.getTestContext().getName()+"_"+result.getMethod().getMethodName());
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	@AfterSuite
    public static void report() {
		reports.flush();
		String pathOfReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport = new File(pathOfReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

    
}