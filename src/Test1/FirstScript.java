package Test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
		// Register chrome driver to lauch google chrome when running the test
		// Set the path of executable  browser driver
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		// Start Browser	
		WebDriver driver = new ChromeDriver();
		
		// System.out.println(driver.getTitle());
		
		driver.manage().window().maximize();	//maximize window of the output
		driver.manage().deleteAllCookies();
				
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		// wait for 30 sec and listen until the element is loaded, else raise an exception "no element found"
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Get website to test; always use http:// or https://
		driver.get("http://dev.ushindi");
		// Thread.sleep(3000);
		
		
		// Get email by id and pass value "evholmbithy@gmail.com"
		// Get submit btn by css class selector and pass a click function. 
		// driver.findElement(By.id("email")).sendKeys("evholmbithy@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("evholmbithy@gmail.com");  //find by xpath
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".submit-btn")).click();
		// driver.findElement(By.name("email")).sendKeys("evholmbithy@gmail.com");  //find by name attribute
		
		// explicit wait by webdriver - waits dynamically by specific conditions 20sec
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		// wait until the visibility that is located by the xpath
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']")));
		boolean status = element.isDisplayed();
		
		
		// Quit Browser
		driver.quit();

	}

}
