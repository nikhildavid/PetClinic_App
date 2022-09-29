package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Runtime.RunTimeEnvironment;


public class HomePage{
	RunTimeEnvironment runtime;
	WebDriver driver;
	
	public HomePage(RunTimeEnvironment runtime) {
		this.runtime=runtime;
		this.driver = runtime.driver;
		System.out.println("Inside home page");
		initialiseObjects();
		
	}
	
	@FindBy(xpath="//span[@class='fa fa-search']")
	WebElement homePage_FindOwnerButton;
	public void click_HomePage_FindOwnerButton() {
	runtime.library.clickElement(homePage_FindOwnerButton, "HomePage_FindOwnerButton");
	}
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement homePage_Logo;
	public void verify_HomePage_Logo_isDisplayed() {
		
	runtime.library.verifyElement_isDisplayed(homePage_Logo,"homePage_Logo");
	}
	

	
	
	private void initialiseObjects() {
		PageFactory.initElements(driver, this);
	}
}
