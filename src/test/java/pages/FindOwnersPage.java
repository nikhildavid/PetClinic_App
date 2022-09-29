package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseSteps;
import Runtime.RunTimeEnvironment;


	public class FindOwnersPage extends BaseSteps{
		RunTimeEnvironment runtime;
		WebDriver driver;
		
		public FindOwnersPage(RunTimeEnvironment runtime) {
			this.runtime=runtime;
			this.driver = runtime.driver;
		
			initialiseObjects();
			
		}
		
		@FindBy(xpath="//a[@class='btn btn-primary']")
		WebElement findOwnerPage_AddOwnerButton;
		public void click_FindOwnerPage_AddOwnerButton() {
			runtime.library.clickElement(findOwnerPage_AddOwnerButton, "OwnerPage_AddOwnerButton");
		}
		
		@FindBy(xpath="//button[@type='submit']")
		WebElement findOwnerPage_FindOwnerButton;
		public void click_FindOwnerPage_FindOwnerButton() {
			runtime.library.clickElement(findOwnerPage_FindOwnerButton, "OwnerPage_FindOwnerButton");
		}
		
		@FindBy(xpath="//input[@id='lastName']")
		WebElement findOwnerPage_LastName;
		public void enter_FindOwnerPage_LastName(String LastName) {
			runtime.library.writeText(findOwnerPage_LastName, "findOwnerPage_LastName", LastName);
		}
		
		private void initialiseObjects() {
			PageFactory.initElements(driver, this);
		}
}
