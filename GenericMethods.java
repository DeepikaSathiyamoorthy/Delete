package com.vstl.generic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import LoginPageAutomation.UtilitiesFunctions;

public class GenericMethods extends UtilitiesFunctions {

	public WebDriver driver;
	
	
	//Application Invoke
	public void invokeApplication() {
		
		System.setProperty("webdriver.chromedriver", System.getProperty("user.dir")+"drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php");
		driver.manage().window().maximize();
		
	}

	
	//Close Current Window
	public void closeCurrentWindow() {
		
		driver.close();
		
	}

	//Close all windows
	public void tearDown() {
			
			driver.quit();
		}
	
	//Get the Driver
	public WebDriver getDriver() {
		return driver;
	}
	
	//Set the Driver
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	//Back to previous Page
	public void goBackToHomePage() {
		driver.navigate().back();
	}
	
	//Thread.Sleep Wait
	public void waitFor(int timeUnitInSecond) {
		
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitInSecond, TimeUnit.SECONDS));
		} catch (Exception e) {
			
		}
	}
	
	//Mouse Hover
	public void mouseHover(String strxpathVale) {
		
		WebElement objWebElement = driver.findElement(By.xpath(strxpathVale));
		Actions objActions = new Actions(driver);
		objActions.moveToElement(objWebElement).perform();
	}
	
	//Verify HomePage Title
	public void verifyPageHomeTitle(String getTitleToVerify) {
		
		String verifyTitle = driver.getTitle();
		if(verifyTitle.equalsIgnoreCase(getTitleToVerify)) 
			System.out.println("Title is Match"); 
					else
				System.out.println("Title not Matches"); 
		System.out.println("Title is " +verifyTitle);
		
		}
	
	//Get Text
	public void getText(String xpathValue) {
		
		String getText = driver.findElement(By.xpath(xpathValue)).getText();
		System.out.println("Get Text value is " +getText);
		
	}
	
	//Verify Current Page Title
	public void verifyCurrentPageTitle(String windowTitle) {
		
		String parentWindow = driver.getWindowHandle();
		Set<String> objSet = driver.getWindowHandles();
		Iterator<String> iteration = objSet.iterator();
		
		while (iteration.hasNext()) {
			String child_window = iteration.next();
			
			if(!parentWindow.equals(child_window)) {
				driver.switchTo().window(child_window);
				String strgetTitle = driver.switchTo().window(child_window).getTitle();
				if(strgetTitle.equalsIgnoreCase(windowTitle)) 
					System.out.println("Title is Match"); 
							else
						System.out.println("Title not Matches"); 
				System.out.println("Title is " +strgetTitle);
				}
			driver.switchTo().window(parentWindow);
		}
		
	} 
	
}

