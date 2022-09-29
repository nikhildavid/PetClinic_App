package Base;


import Runtime.RunTimeEnvironment;
import pages.PageObjectManager;

public class BaseSteps {
	
	public RunTimeEnvironment runtime;
	public PageObjectManager pages;
	
	public void initialiseRunTime(String Browser,String TestName) {
		System.out.println("Inside initialise");
		runtime= new RunTimeEnvironment(Browser, TestName);
		
		pages=new PageObjectManager(runtime);
	
		
	}

}
