package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class FirstTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Robot robot = new Robot();
		
	
		
		//timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		try {
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
			WebElement loginButton = driver.findElement(By.id("btnLogin"));
			driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginButton)).sendKeys("abc");
			Thread.sleep(2000);
			//driver.get("https://trytestingthis.netlify.app/");
			//driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
			/*
			 * List<WebElement> options = driver.findElements(By.name("Optionwithcheck[]"));
			 * for(WebElement element: options) { System.out.println(element.getText()); }
			 */
			/*
			 * String originalWindow = driver.getWindowHandle();
			 * driver.navigate().to("https://automationstepbystep.com");
			 * 
			 * System.out.println(driver.getCurrentUrl());
			 * System.out.println(driver.getTitle()); driver.navigate().back();
			 * Thread.sleep(2000); driver.navigate().forward();
			 * System.out.println("check 1"); Thread.sleep(2000);
			 * driver.navigate().refresh(); System.out.println("check 2");
			 * Thread.sleep(2000); driver.navigate().back();
			 * 
			 * driver.switchTo().newWindow(WindowType.WINDOW);
			 * driver.switchTo().window(originalWindow);
			 * System.out.println(driver.getCurrentUrl());
			 */
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		} finally {
			Thread.sleep(2000);
			driver.close();
			
		}
		
		
		
	
		
	}
}
