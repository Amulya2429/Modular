package modularFramework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.BaseClass;
import utilities.DataProviders;
import utilities.ExtentManager;

public class Modular extends BaseClass {
 
 
 /*@Test(priority=0)
public void logintest() {
	invokeurl();
	login();
}*/
	@Test(priority=1)
	public void invokeurl1() {
		try {
		invokeurl();
	Alert myalert=driver.switchTo().alert();
		if(((WebElement) myalert).isDisplayed()) {
			myalert.accept();
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
 @Test(priority=2, dataProvider="LoginData",dataProviderClass=DataProviders.class)
 public void addtocart(String username,String password) throws InterruptedException {
	// invokeurl();
	 login(username, password);
//	 selectproduct();
	// secondproduct();
	// thirdproduct();
	// checkout();
	 
 }
 @Test(priority=3)
 public void login1() throws InterruptedException {
	 selectproduct();
	 secondproduct();
	 thirdproduct();
 }
 @Test(priority=4,dataProvider="LogoutData",dataProviderClass=DataProviders.class)
 public void checkout1(String firstname,String lastname,String pin) throws InterruptedException {
	 checkout(firstname, lastname, pin);
 }
  
	public void invokeurl() {
		try {
		test=reports.createTest("invokeurl");
		//open url
		driver.get("https://www.saucedemo.com/v1/index.html");
		test.pass("successfully opened");
		}catch(Exception e) {
			
		}
	}
	public void login(String username,String password) {
		test=reports.createTest("login");
		//enter user name
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
	//enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		//click login button
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		test.pass("login successfully");
	}
	public void selectproduct() throws InterruptedException {
		try {
		test=reports.createTest("select product one");
		//to add the product 1
		driver.findElement(By.xpath("//button[@class='btn_primary btn_inventory']")).click();
		//click on cart
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
		//click on Menu
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		//click on all items
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='All Items']")).click();
		test.pass("succesfully added one product");
		}catch(Exception e) {
			
		}
	}
	public void secondproduct() throws InterruptedException {
		test=reports.createTest("select second product");
		// select the red tshirt 2
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='item_3_title_link']")).click();
		//product add to cart
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		//shoping container
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
		// click on menu
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		test.pass("succesfully added redtshirt");
	}
	public void thirdproduct() throws InterruptedException {
		try {
		test=reports.createTest("select third product");
		//click on all items
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='All Items']")).click();
		//click on light 3
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='item_0_title_link']")).click();
		//click on add to cart
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		//click on shoping cart
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
		test.pass("succesfully added third product");
		test=reports.createTest("removed third product");
		//remove product
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[5]/div[2]/div[2]/button")).click();
		test.pass("succesfully removed third product");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void checkout(String firstname,String lastname,String pin) throws InterruptedException {
		test=reports.createTest("checkout");
		Thread.sleep(1000);
		//click on checkout
		driver.findElement(By.xpath("//a[@class='btn_action checkout_button']")).click();
	   Thread.sleep(1000);
		
		//firstname
		WebElement fname= driver.findElement(By.xpath("//input[@id='first-name']"));
		 fname.click();
		fname.sendKeys(firstname);
		//lastname
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastname);
		//postlecode
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(pin);
		//click on submit
		driver.findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
		//click on finish
		driver.findElement(By.xpath("//a[text()='FINISH']")).click();
		test.pass("logout successfully");
     }
	
	
	
}
