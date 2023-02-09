package vTigerContactTestScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilitity.BaseClass;
import vTiger.GenericUtilitity.PropertyFileUtility;
import vTiger.GenericUtilitity.WebDriverUtility;
import vTiger.GenericUtilitity.javaUtility;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactsPage;
import vTiger.ObjectRepository.CreatingNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;
@Listeners(vTiger.GenericUtilitity.ListenersImplementationClass.class)
public class ContactWithOrgBaseClassTestNg extends BaseClass {
	
			@Test(groups = "smokesuite")
			public void creatWithorgTest() throws IOException
			{
			// Step 2: Read all the required Data
			String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 7, 2);
			String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 7, 3)+jUtil.getRandomNumber();
			
			//Step 5: Navigate to Organizations Link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationLink();
			Reporter.log("---Click on orgaization Link---",true);
			//Step 6: Click on Organizations look up image
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickOnCreateOrgLookUpImg();
			Reporter.log("---Click on orgaization lookup image---",true);
			//Step 7: Create new organization and save
			CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			cnop.createNewOrganization(ORGNAME);
			Reporter.log("---Crate orgaization an save---",true);
			//Step 8: Validate for Organization
			OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
			String OrgHeader = oip.getOrganizationHeader();
			if(OrgHeader.contains(ORGNAME))
			{
				System.out.println(OrgHeader+"Org created");
			}
			else
			{
				System.out.println("Org not created");
			}
			Reporter.log("---orgheader same---",true);
			//Assert.assertTrue(OrgHeader.contains(ORGNAME));
			//Step 9: Navigate to contacts link
			hp.clickOnContactsLink();
			/*String expTitle = "Admistrator - Contacts - vtiger CRM 5 - Commercial";
			String actTitle = driver.getTitle();
			Assert.assertEquals(actTitle, expTitle);*/
			Reporter.log("---Click on contactLink---",true);
			//Step 10: Click on create contact look up image
			ContactsPage cp = new ContactsPage(driver);
			cp.clickOnCreateContactLookUpImg();
			Reporter.log("---create contact loolup image---",true);
			//Step 11: Create new Contact
			CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
			cncp.createNewContact(driver, LASTNAME, ORGNAME);
			Reporter.log("---Create new coontact---",true);
			//Step 12: Validate
			ContactsInfoPage cip = new ContactsInfoPage(driver);
			String ContactHeader = cip.getContactHeader();
			Assert.assertTrue(ContactHeader.contains(LASTNAME));
			Reporter.log("---Contact created same---",true);
			
			
		}


}
