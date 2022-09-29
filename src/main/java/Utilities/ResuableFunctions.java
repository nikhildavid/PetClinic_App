package Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ResuableFunctions {

	WebDriver driver;
	WebDriverWait wait;
	Select drop;
	ExtentTest test;

	public ResuableFunctions(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		this.test = test;

	}

	public ResuableFunctions() {

	}

	public void clickElement(WebElement e, String ElementInfo) {

		waitunitlElementVisible(e, ElementInfo).click();
		test.info("Clicked the element: " + ElementInfo);

	}

	public void writeText(WebElement e, String ElementInfo, String text) {
		waitunitlElementVisible(e, ElementInfo).sendKeys(text);

		test.info("Entered value in: " + ElementInfo);
	}

	public String readText(WebElement e, String ElementInfo) {
		waitunitlElementVisible(e, ElementInfo);
		test.info("Retrieved text from: " + ElementInfo);
		return e.getText();

	}

	public void selectDropownByValue(WebElement e, String value) {

		drop = new Select(e);
		drop.selectByValue(value);
	}

	public WebElement waitunitlElementVisible(WebElement e, String ElementInfo) {
		test.info("Waiting for element: " + ElementInfo);
		wait.until(ExpectedConditions.visibilityOf(e));
		test.info(ElementInfo, MediaEntityBuilder
				.createScreenCaptureFromBase64String(takeScreenShot(driver, "Screenshot"), "ElementInfo").build());
		return e;

	}

	public String generateTimestamp() {

		return (new SimpleDateFormat("MM-dd-yyyy-hhmmss").format(new java.util.Date()));
	}

	public String takeScreenShot(WebDriver driver, String screenshotName) {

		System.out.println("Inside screenshot");
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

	public void AssertStringsEqual_True(String s1, String s2) {
		Assert.assertTrue(s1.equals(s2));
	}

	public void verifyElement_isDisplayed(WebElement e, String ElementInfo) {
		waitunitlElementVisible(e, ElementInfo);
		Assert.assertTrue(e.isDisplayed());
	}

	public String foramtDate_yyyyMMdd_to_ddMMyyyy(String dateAsString) {
		DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = originalFormat.parse(dateAsString);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return targetFormat.format(date);
	}

	public void selectDropDownByValue(WebElement e, String value) {
		waitunitlElementVisible(e, "");
		Select typeDropMenu = new Select(e);
		typeDropMenu.selectByValue(value);
	}
}
