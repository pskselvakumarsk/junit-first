package com.amazon.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
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

public class AmazonProgram {
	static WebDriver driver;
	static long startTime;
	@BeforeClass
	public static void BrowserLaunch() {
		System.out.println("Launch Method");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test\\eclipse-workspace\\junit-first\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}
	
	@Before
	public void beforemethod() {
		System.out.println("BeforeMethod");
		startTime = System.currentTimeMillis();
		
	}
	@After
	public void aftermethod() {
		System.out.println("AfterMethod");
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken is : "+(endTime-startTime));
	}
	@AfterClass
	public static void browserquit() {
		System.out.println("Browserquit");
	}
	@Test
	public void method1() {
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("oneplus tv 32 inch tv full hd",Keys.ENTER);
		WebElement Choose = driver.findElement(By.xpath("//div[contains(@class,'a-section a-spacing-none s-padding-right-small s-title-instructions-style')]"));
		Choose.click();
	}
	@Test
	public void method3() throws IOException {
		TakesScreenshot t = (TakesScreenshot)driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\Test\\eclipse-workspace\\junit-first\\target\\az.png");
		FileUtils.copyFile(source,target);
		
				
	}
	

}
