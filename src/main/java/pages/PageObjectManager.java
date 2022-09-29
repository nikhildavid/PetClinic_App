package pages;
import Runtime.RunTimeEnvironment;
public class PageObjectManager {

	public RunTimeEnvironment runtime;
	public PageObjectManager(RunTimeEnvironment runtime) {
		this.runtime=runtime;
		
	}
	
	HomePage homepage;
	
	public HomePage getHomePage() {
		if(homepage==null) {
			homepage = new HomePage(runtime);
			return  homepage;
		}
		return homepage;
	}
	
FindOwnersPage findownerspage;
	
	public FindOwnersPage getFindOwnersPage() {
		if(findownerspage==null) {
			findownerspage = new FindOwnersPage(runtime);
			return  findownerspage;
		}
		return findownerspage;
	}
	
AddOwnersPage ownerspage;
	
	public AddOwnersPage getOwnersPage() {
		if(ownerspage==null) {
			ownerspage = new AddOwnersPage(runtime);
			return  ownerspage;
		}
		return ownerspage;
	}
OwnerDetailsPage ownerdetailspage;
	
	public OwnerDetailsPage getOwnerDetailsPage() {
		if(ownerdetailspage==null) {
			ownerdetailspage = new OwnerDetailsPage(runtime);
			return  ownerdetailspage;
		}
		return ownerdetailspage;
	}
	
OwnerInformationPage ownerInformationpage;
	
	public OwnerInformationPage getOwnerInformationPage() {
		if(ownerInformationpage==null) {
			ownerInformationpage = new OwnerInformationPage(runtime);
			return  ownerInformationpage;
		}
		return ownerInformationpage;
	}
	
NewPetPage newPetPage;
	
	public NewPetPage getNewPetPage() {
		if(newPetPage==null) {
			newPetPage = new NewPetPage(runtime);
			return  newPetPage;
		}
		return newPetPage;
	}
}
