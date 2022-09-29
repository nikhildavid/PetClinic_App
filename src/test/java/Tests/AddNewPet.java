package Tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseSteps;
import Managers.ExtentTestManager;

public class AddNewPet {

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
	public void add_Pet_OwnerProfile() {
		String PetName = basesteps.runtime.readData.getPetDetails("PetName");
		String PetBdate = basesteps.runtime.readData.getPetDetails("PetBdate");
		String PetType = basesteps.runtime.readData.getPetDetails("PetType");
		String LastName = basesteps.runtime.readData.getOwnerDetails("LastName");
		basesteps.runtime.driver.get(basesteps.runtime.readData.readConfigProperty("url"));
		basesteps.pages.getHomePage().click_HomePage_FindOwnerButton();
		basesteps.pages.getFindOwnersPage().enter_FindOwnerPage_LastName(LastName);
		basesteps.pages.getFindOwnersPage().click_FindOwnerPage_FindOwnerButton();
		basesteps.pages.getOwnerInformationPage().clickOwnerInformationPage_AddPetButton();
		basesteps.pages.getNewPetPage().enterNewPetPage_PetName(PetName);
		basesteps.pages.getNewPetPage().enterNewPetPage_PetDOB(PetBdate);
		basesteps.pages.getNewPetPage().selectnewPetPage_PetTypeDropdown(PetType);
		basesteps.pages.getNewPetPage().clickNewPetPage_SubmitButton();

		String PetNameCheck = basesteps.pages.getOwnerInformationPage().readOwnerInformation_PetName();
		String BDateCheck = basesteps.pages.getOwnerInformationPage().readOwnerInformation_PetDOB();
		String TypeCheck = basesteps.pages.getOwnerInformationPage().readOwnerInformation_PetType();
	

		BDateCheck = basesteps.runtime.library.foramtDate_yyyyMMdd_to_ddMMyyyy(BDateCheck);
		
		basesteps.runtime.library.AssertStringsEqual_True(PetNameCheck, PetName);
		basesteps.runtime.library.AssertStringsEqual_True(BDateCheck, PetBdate);
		basesteps.runtime.library.AssertStringsEqual_True(TypeCheck, PetType);

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
