package com.stepdefinition.amazon;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Clothes {
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
		
		try {
			driver.findElement(By.xpath("//button[text()='✕']")).click();
	}
		catch (Exception e) {
			System.out.println("Login is not required");
		}
	}
	
	static String r1;
	@Test
	public void m2() {
		
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Yonex Duora",Keys.ENTER);
		
		WebElement racket = driver.findElement(By.xpath("//a[contains(text(),'YONEX Duora 77')]"));
		String r1 = racket.getText();
		System.out.println(r1);
		racket.click();
		

	}
	
	@Test
	public void m3() throws InterruptedException {
		
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for (String x : child) {
			if (!x.equals(parent)) {
				driver.switchTo().window(x);
				Thread.sleep(5000);
				System.out.println("Window is handled");
			}
			
		}
		
	}
	
	@Test
	public void m4() {
		
		WebElement buynow = driver.findElement(By.xpath("//button[text()='BUY NOW']"));
		Assert.assertTrue(buynow.isDisplayed());
		
		WebElement racket = driver.findElement(By.xpath("//span[contains(text(),'YONEX Duora 77')]"));
		String r2 = racket.getText();
		System.out.println(r2);
		
		//Assert.assertEquals(r1, r2);
		
		
	}
	
	@Test
	public void m5() throws IOException {
		
		TakesScreenshot tk = (TakesScreenshot)driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File desc = new File("C:\\Users\\Hp\\eclipse-workspace\\git\\Junitproject\\target\\report.jpg");
		FileUtils.copyFile(source, desc);
		
		System.out.println("Screenshot is taken");
			
		
		
	}
	
	
	

}
