package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage 
{
	 WebDriver driver;

	    By logoutButton = By.xpath("//a[text()='Log out']");
	    By headerText = By.tagName("h1");

	    public DashboardPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isLogoutVisible() {
	        return driver.findElement(logoutButton).isDisplayed();
	    }

	    public String getHeaderText() {
	        return driver.findElement(headerText).getText();
	    }
}
