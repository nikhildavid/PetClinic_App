package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Runtime.RunTimeEnvironment;


public class AddOwnersPage{

		RunTimeEnvironment runtime;
		WebDriver driver;

		public AddOwnersPage(RunTimeEnvironment runtime) {
			this.runtime=runtime;
			this.driver = runtime.driver;
		
			initialiseObjects();
			
			
		}
		
		@FindBy(xpath="//input[@id='firstName']")
		WebElement addOwnerspage_FirstName;
		
		public void enterFirstName(String fisrtname) {
			runtime.library.writeText(addOwnerspage_FirstName, "FirstName", fisrtname);
		}
		
		@FindBy(xpath="//input[@id='lastName']")
		WebElement addOwnerspage_LastName;
		
		public void enterLastName(String lastname) {
			runtime.library.writeText(addOwnerspage_LastName, "LastName", lastname);
		}
	
		@FindBy(xpath="//input[@id='address']")
		WebElement addOwnerspage_Address;
		
		public void enterAddress(String address) {
			runtime.library.writeText(addOwnerspage_Address, "Address", address);
		}
	
		@FindBy(xpath="//input[@id='city']")
		WebElement addOwnerspage_City;
		
		public void enterCity(String city) {
			runtime.library.writeText(addOwnerspage_City, "City", city);
		}
		
		@FindBy(xpath="//input[@id='telephone']")
		WebElement addOwnerspage_Telephone;
		
		public void enterTelephone(String telephone) {
			runtime.library.writeText(addOwnerspage_Telephone, "Telephone", telephone);
		}
		
	
		@FindBy(xpath="//button[@class='btn btn-primary']")
		WebElement addOwnerspage_AddOwnerButton;
		
		public void clickAddOwnerButton() {
			runtime.library.clickElement(addOwnerspage_AddOwnerButton, "AddOwner");
		}
		private void initialiseObjects() {
			PageFactory.initElements(driver, this);
		}
}
