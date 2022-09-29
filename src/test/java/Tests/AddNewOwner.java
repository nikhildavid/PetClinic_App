package Tests;

import org.testng.ITestContext;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseSteps;
import Managers.ExtentTestManager;

public class AddNewOwner {

	String TestCaseName;
	BaseSteps basesteps;

	@BeforeTest
	public void startTest(final ITestContext testContext) {
		basesteps = new BaseSteps();
		TestCaseName = testContext.getName();
		System.out.println("Inside start test");
		basesteps.initialiseRunTime("chrome", TestCaseName);

	}

	@Test
	public void addNewOwner_ValidateDetails(){
		
		String firstName = basesteps.runtime.readData.getOwnerDetails("FirstName");
		String lastName = basesteps.runtime.readData.getOwnerDetails("LastName");
		String address = basesteps.runtime.readData.getOwnerDetails("Address");
		String city = basesteps.runtime.readData.getOwnerDetails("City");
		String telephone = basesteps.runtime.readData.getOwnerDetails("Telephone");
		basesteps.runtime.driver.get(basesteps.runtime.readData.readConfigProperty("url"));
		basesteps.pages.getHomePage().click_HomePage_FindOwnerButton();

		basesteps.pages.getFindOwnersPage().click_FindOwnerPage_AddOwnerButton();
		basesteps.pages.getOwnersPage().enterFirstName(firstName);
		basesteps.pages.getOwnersPage().enterLastName(lastName);
		basesteps.pages.getOwnersPage().enterAddress(address);
		basesteps.pages.getOwnersPage().enterCity(city);
		basesteps.pages.getOwnersPage().enterTelephone(telephone);
		basesteps.pages.getOwnersPage().clickAddOwnerButton();

		String NameCheck = basesteps.pages.getOwnerDetailsPage().getOwnerDetailsPage_Name();

		String AddCheck = basesteps.pages.getOwnerDetailsPage().getOwnerDetailsPage_Address();
		String CityCheck = basesteps.pages.getOwnerDetailsPage().getOwnerDetailsPage_City();
		String TeleCheck = basesteps.pages.getOwnerDetailsPage().getOwnerDetailsPage_Telephone();

		basesteps.runtime.library.AssertStringsEqual_True(NameCheck, firstName + " " + lastName);
		basesteps.runtime.library.AssertStringsEqual_True(AddCheck, address);
		basesteps.runtime.library.AssertStringsEqual_True(CityCheck, city);
		basesteps.runtime.library.AssertStringsEqual_True(TeleCheck, telephone);

	}
	
	
	
	@AfterTest
	public void teardown() {
		basesteps.runtime.driver.close();
	
	}
	@AfterSuite
	public void r() {
		basesteps.runtime.driver.quit();
		ExtentTestManager.endTest();
	}

}
