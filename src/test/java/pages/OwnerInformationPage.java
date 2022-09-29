package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Runtime.RunTimeEnvironment;

public class OwnerInformationPage {

	RunTimeEnvironment runtime;
	WebDriver driver;
	
	public OwnerInformationPage(RunTimeEnvironment runtime) {
		this.runtime=runtime;
		this.driver = runtime.driver;
	
		initialiseObjects();
		
	}
	@FindBy(xpath="//a[contains(text(),'Pet')]")
	WebElement ownerInformationPage_AddPetButton;
	public void clickOwnerInformationPage_AddPetButton() {
		runtime.library.clickElement(ownerInformationPage_AddPetButton, "ownerInformationPage_AddPetButton");
	}
	
	//String PetNameCheck = driver.findElement(By.xpath("//dl[@class='dl-horizontal']/dd[1]")).getText();
	@FindBy(xpath="//dl[@class='dl-horizontal']/dd[1]")
	WebElement ownerInformation_PetName;
	public String readOwnerInformation_PetName() {
		return runtime.library.readText(ownerInformation_PetName, "ownerInformation_PetName");
	}
	//String BDateCheck = driver.findElement(By.xpath("//dl[@class='dl-horizontal']/dd[2]")).getText();
	@FindBy(xpath="//dl[@class='dl-horizontal']/dd[2]")
	WebElement ownerInformation_PetDOB;
	public String readOwnerInformation_PetDOB() {
		return runtime.library.readText(ownerInformation_PetDOB, "ownerInformation_PetDOB");
	}
	//String TypeCheck = driver.findElement(By.xpath("//dl[@class='dl-horizontal']/dd[3]")).getText();
	@FindBy(xpath="//dl[@class='dl-horizontal']/dd[3]")
	WebElement ownerInformation_PetType;
	public String readOwnerInformation_PetType() {
		return runtime.library.readText(ownerInformation_PetType, "ownerInformation_PetType");
	}
	private void initialiseObjects() {
		PageFactory.initElements(driver, this);
	}
}
