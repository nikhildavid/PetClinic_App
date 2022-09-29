package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseSteps;
import Runtime.RunTimeEnvironment;


public class OwnerDetailsPage extends BaseSteps {

		RunTimeEnvironment runtime;
		WebDriver driver;
	
		public OwnerDetailsPage(RunTimeEnvironment runtime) {
			this.runtime=runtime;
			this.driver = runtime.driver;

			initialiseObjects();
			
		}
		
		
		@FindBy(xpath="//th[text()='Name']/following-sibling::td/b")
		WebElement ownerDetailsPage_Name;
		public String getOwnerDetailsPage_Name(){
			return runtime.library.readText(ownerDetailsPage_Name, "ownerDetailsPage_Name");
		}
		
		@FindBy(xpath="//th[text()='Address']/following-sibling::td")
		WebElement ownerDetailsPage_Address;
		public String getOwnerDetailsPage_Address(){
			return runtime.library.readText(ownerDetailsPage_Address, "ownerDetailsPage_Address");
		}
		
		@FindBy(xpath="//th[text()='City']/following-sibling::td")
		WebElement ownerDetailsPage_City;
		public String getOwnerDetailsPage_City(){
			return runtime.library.readText(ownerDetailsPage_City, "ownerDetailsPage_City");
		}
		
		@FindBy(xpath="//th[text()='Telephone']/following-sibling::td")
		WebElement ownerDetailsPage_Telephone;
		public String getOwnerDetailsPage_Telephone(){
			return runtime.library.readText(ownerDetailsPage_Telephone, "ownerDetailsPage_Telephone");
		}
		
		private void initialiseObjects() {
			PageFactory.initElements(driver, this);
		}
}
