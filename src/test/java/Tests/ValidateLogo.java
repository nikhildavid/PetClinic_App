package Tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseSteps;
import utils.ExtentTestManager;


public class ValidateLogo {
	
	String TestCaseName;
	BaseSteps basesteps;
	@BeforeTest
	public void startTest(final ITestContext testContext) {
		basesteps = new BaseSteps();
		TestCaseName = testContext.getName();
		System.out.println("Inside start test");
		basesteps.initialiseRunTime("chrome", TestCaseName);

	}
	
	@Test
	public void validateHomePageLogo(){
	
		basesteps.runtime.driver.get(basesteps.runtime.readData.readConfigProperty("url"));
		basesteps.pages.getHomePage().verify_HomePage_Logo_isDisplayed();

		
	}
	

	
	@AfterTest
	public void teardown() {
		basesteps.runtime.driver.close();

	}
	@AfterSuite
	public void r() {
		basesteps.runtime.driver.quit();
		ExtentTestManager.endTest();
	}
	
}
