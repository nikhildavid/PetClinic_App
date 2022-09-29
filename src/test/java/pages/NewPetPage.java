package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Runtime.RunTimeEnvironment;

public class NewPetPage {

	RunTimeEnvironment runtime;
	WebDriver driver;
	
	public NewPetPage(RunTimeEnvironment runtime) {
		this.runtime=runtime;
		this.driver = runtime.driver;
	
		initialiseObjects();
		
	}
	@FindBy(xpath="//input[@id='name']")
	WebElement newPetPage_PetName;
	public void enterNewPetPage_PetName(String PetName) {
		
		runtime.library.writeText(newPetPage_PetName, "newPetPage_PetName", PetName);
	}

	
	@FindBy(xpath="//input[@id='birthDate']")
	WebElement newPetPage_PetDOB;
	public void enterNewPetPage_PetDOB(String PetDOB) {
		
		runtime.library.writeText(newPetPage_PetDOB, "newPetPage_PetDOB", PetDOB);
	}
	
	
	@FindBy(xpath="//select[@id='type']")
	WebElement newPetPage_PetTypeDropdown;
	public void selectnewPetPage_PetTypeDropdown(String value) {
		runtime.library.selectDropDownByValue(newPetPage_PetTypeDropdown, value);
	}
	@FindBy(xpath="//button[@type='submit']")
	WebElement newPetPage_SubmitButton;
	public void clickNewPetPage_SubmitButton() {
		
		runtime.library.clickElement(newPetPage_SubmitButton, "newPetPage_SubmitButton");
	}

	private void initialiseObjects() {
		PageFactory.initElements(driver, this);
	}
}
