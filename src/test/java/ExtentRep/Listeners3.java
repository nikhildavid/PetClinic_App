package ExtentRep;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Base.BaseSteps;

public class Listeners3 implements ITestListener{
	BaseSteps basesteps;
	//ExtentTest test;
	//ExtentReports extent = ExtentManager.getReportObject();
	String TestCaseName;
	public void onTestStart(ITestResult result) {
	//	System.out.println("Inside onTestStart");
		basesteps.runtime.test=basesteps.runtime.extent.createTest(TestCaseName);
	//	test=extent.createTest(TestCaseName);
		//test=extent.createTest(result.getMethod().getMethodName());
		//System.out.println("Created extent test object");

	}

	public void onTestSuccess(ITestResult result) {

		//test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		
//		System.out.println("Test Failed");
//	test.log(Status.FAIL, "Test Failed");
//	
//		test.addScreenCaptureFromPath("C:\\Users\\Nikhil\\Desktop\\pic1.png","Failed Step");
//		extent.flush();
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}
	
	

	public void onStart(ITestContext context) {

		TestCaseName=context.getName();

	}

	public void onFinish(ITestContext context) {

		basesteps.runtime.extent.flush();
	}

}
