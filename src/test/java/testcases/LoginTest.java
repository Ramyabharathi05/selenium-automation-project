package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ScreenshotUtils;

public class LoginTest  extends BaseClass
{
	 @BeforeMethod
	    public void setup() {
	        launchBrowser();
	    }

	 @Test(dataProvider = "loginData")
	 public void loginWithExcel(String username, String password, String expectedResult) {
	        driver.get("https://practicetestautomation.com/practice-test-login/");

	        LoginPage login = new LoginPage(driver);
	        login.enterUsername(username);
	        login.enterPassword(password);
	        login.clickLogin();

	        if (expectedResult.equalsIgnoreCase("success")) {
	            // Success case: Logout button must be visible
	        	DashboardPage dashboard = new DashboardPage(driver);
	            Assert.assertTrue(dashboard.isLogoutVisible(), "Expected success, but login failed.");
	        } else {
	            // Failure case: Error message must be visible
	            boolean isErrorVisible = driver.findElement(By.id("error")).isDisplayed();  // adjust locator as needed
	            Assert.assertTrue(isErrorVisible, "Expected failure, but login succeeded.");
	        }
	 }

	    @AfterMethod
	    public void tearDown(ITestResult result) {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            ScreenshotUtils.takeScreenshot(driver, result.getName());
	        }
	        closeBrowser();
	    }

	    @DataProvider(name = "loginData")
	    public Object[][] getData() {
	        return ExcelUtils.getExcelData("config/TestData.xlsx", "Sheet1");
	    }

}
