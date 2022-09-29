package Runtime;

import org.openqa.selenium.WebDriver;

import utils.ExtentManager;
import utils.ExtentTestManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Driver.Browser;
import Utilities.ResuableFunctions;
import Managers.DataManager;

public class RunTimeEnvironment {
	
	Browser B = new Browser();
	public WebDriver driver;
	String TestCaseName;
	public ExtentTest test;
	public ExtentReports extent;
	public DataManager readData;
	public ResuableFunctions library;
	
	public RunTimeEnvironment (String Browser, String TestCaseName) {
		System.out.println("Inside run time environment");
		this.driver=B.getDriver(Browser);
		this.TestCaseName=TestCaseName;
		//extent=ExtentManager.createExtentReports();
		ExtentTestManager.startTest(TestCaseName, "TestDesc");
		test=ExtentTestManager.getTest();
		//=extent.createTest(TestCaseName);
		readData=new DataManager();
		library = new ResuableFunctions(driver,test);
		
	}

}
