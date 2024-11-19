package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import utilities.ExtentManager;

public class BaseClass extends ExtentManager {
	protected static WebDriver driver;
	@BeforeClass
	 public void setup() {
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 }
	 @AfterClass
	 public void close() {
		 driver.close();
	 }
		
	public static String CaptureScreen(String tname) {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File SourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		//user.dir")+".\\Screenshots\\
		String targetFilePath=System.getProperty("user.dir")+"/screenshots/" +tname+  "_" + timeStamp +".png";
		File targetFile=new File(targetFilePath);//C:\Users\hi\eclipse-workspace\LUMA_Application\Screenshots
		
		SourceFile.renameTo(targetFile);
		
		return targetFilePath;
		
	
	
}
}
