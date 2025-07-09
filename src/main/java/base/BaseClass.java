package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass
{
	 public static WebDriver driver;

	    public void launchBrowser() {
	        driver = new ChromeDriver();  // SeleniumManager handles driver
	        driver.manage().window().maximize();
	        driver.get("https://www.google.com");
	    }

	    public void closeBrowser() 
	    {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
