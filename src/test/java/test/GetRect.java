package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetRect {

	private static WebDriver driver;

	@BeforeMethod
	void Login() throws InterruptedException {
		String browser = "chrome";
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get("https://qavbox.github.io/demo/webtable/");
		Thread.sleep(2000);
	}

	@Test
	public void ElScreenshot() throws InterruptedException {

		WebElement el = driver.findElement(By.id("regform"));
		Rectangle rect = el.getRect();
		// WebDriverWait wait = new WebDriverWait(driver, 10);

		System.out.println("X-Axis - " + rect.x); // from left top corner of element
		System.out.println("Y-Axis - " + rect.y);
		System.out.println("Element Width - " + rect.width);
		System.out.println("Element Height - " + rect.height);

		// OR

		System.out.println(rect.getX());
		System.out.println(rect.getY());
		System.out.println(rect.getWidth());
		System.out.println(rect.getHeight());

		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void clickButton() {
		driver.manage().window().maximize();
		driver.get("https://qavbox.github.io/demo/signup/");
//		WebElement btn_click = driver.findElement(By.name("home"));
		WebElement btn_click = driver.findElement(By.cssSelector("input[name='home']"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btn_click.click();
		// or, we can even directly identify the element and perform action
		// driver.findElement(By.name("commit")).click();

		driver.quit();
	}
	
	@Test
	public void openNewTab() throws InterruptedException {
		driver.get("https://qavbox.github.io/demo/signup/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('','_blank');");


        String parentWindow = driver.getWindowHandle();
        Set<String> tabs = (Set<String>)driver.getWindowHandles();
        System.out.println(tabs.size());
        for(String tab : tabs)
        {
        	//switch only if it's not parent window
            if(tab.equals(parentWindow)) { 
            	
            driver.switchTo().window(tab);
            driver.get("https://yahoo.com");
//            driver.get("https://qavbox.github.io/demo/");
            System.out.println(driver.getTitle());
            //do some other validation
            }
        }
        
        driver.switchTo().window(parentWindow); //back to parent parentWindow
        //do something
        Thread.sleep(2000);
        driver.quit();
	}

}