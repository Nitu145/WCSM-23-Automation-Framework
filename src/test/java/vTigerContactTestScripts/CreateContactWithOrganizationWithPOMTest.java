package vTigerContactTestScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilitity.PropertyFileUtility;
import vTiger.GenericUtilitity.WebDriverUtility;
import vTiger.GenericUtilitity.WebDriverUtilityNitu;
import vTiger.GenericUtilitity.javaUtility;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactsPage;
import vTiger.ObjectRepository.CreatingNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrganizationWithPOMTest{
	@Test(groups = "smokesuite")
	 public void createconwithTest() throws IOException{

		// Step 1: Create Object Of all the required libraries
		javaUtility jUtil = new javaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		PropertyFileUtility eUtil = new PropertyFileUtility();

		// Step 2: Read all the required Data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3)+jUtil.getRandomNumber();

		// Step 3: Launch the browser
		WebDriver driver = null;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

		// Step 4: Login to App
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
		//Step 5: Navigate to Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 6: Click on Organizations look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 7: Create new organization and save
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
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
		//Assert.assertTrue(OrgHeader.contains(ORGNAME));//true false
		//Step 9: Navigate to contacts link
		hp.clickOnContactsLink();
	
		//Step 10: Click on create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		
		//Step 11: Create new Contact
		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
	
		//Step 12: Validate
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		if(ContactHeader.contains(LASTNAME))
		{
			System.out.println(ContactHeader+"-PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Step 12: logout of App
		hp.logoutOfApp(driver);
		
		
	}

}
