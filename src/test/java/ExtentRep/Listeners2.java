package ExtentRep;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners2 implements ITestListener{

	public String TestCaseName;
	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}
	
	

	public void onStart(ITestContext context) {

		System.out.println("Inside onStart");
		TestCaseName=context.getName();
		System.out.println(TestCaseName);
	}

	public void onFinish(ITestContext context) {

	}

}
