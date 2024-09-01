package com.stepdefinition.amazon;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class TvPurchase {
	
static WebDriver driver;
	
	@BeforeClass
	public static void launch() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\eclipse-workspace\\git\\Junitproject\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@AfterClass
	
	public static void close() {
		driver.quit();
	}
	
	static long starttime;
	@Before
	public void startTime() {
		long starttime = System.currentTimeMillis();
	}
	
	@After
	public void endTime() {
		long endTime = System.currentTimeMillis();
	System.out.println("Time Taken :"+(endTime - starttime));
	}
	
	
	@Test
	
	public void m1() {
		
		try{
			WebElement closeIcon = driver.findElement(By.xpath("//button[text()='✕']"));
			closeIcon.isDisplayed();
			closeIcon.click();
			
		}
		catch (Exception e) {
			System.out.println("login is not required");
		}
	}
	
	static String fn;
	@Test
	
	public void m2() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("SAMSUNG TV",Keys.ENTER);
		
		WebElement tvname = driver.findElement(By.xpath("(//div[contains(text(),'SAMSUNG')])[2]"));
		fn = tvname.getText();
		System.out.println(fn);
		Thread.sleep(2000);
		tvname.click();
		
		
	
		
	}
	
@Test
	
	public void m3() {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		
		for (String x : child) {
			
			if (!x.equals(parent)) {
				driver.switchTo().window(x);
				System.out.println("window is handled");
			}
			
		}
	}
	

}
