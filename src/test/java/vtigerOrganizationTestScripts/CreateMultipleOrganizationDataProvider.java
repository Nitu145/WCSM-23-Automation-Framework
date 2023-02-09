package vtigerOrganizationTestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilitity.ExcelFileUtility;
import vTiger.GenericUtilitity.PropertyFileUtility;
import vTiger.GenericUtilitity.WebDriverUtility;
import vTiger.GenericUtilitity.javaUtility;
import vTiger.ObjectRepository.CreatingNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrganizationDataProvider {
	//Step1- create object of all required utility
	javaUtility jUtil=new javaUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	@Test(dataProvider = "OrgName")
	public void createMultiOrgTest(String Org, String Industry) throws IOException {
		         String OrgName=Org+jUtil.getRandomNumber();
				
				//step2- read the data from property file
				String Browser=pUtil.readDataFromPropertyFile("browser");
				String URL=pUtil.readDataFromPropertyFile("url");
				String USERNAME=pUtil.readDataFromPropertyFile("username");
				String PASSWORD=pUtil.readDataFromPropertyFile("password");
				
				//read the data from excel sheet
				//String ORGNAME=eUtil.readDataFromExcelFile("organizations",4,2)+jUtil.getRandomNumber();
				//String IndustryName=eUtil.readDataFromExcelFile("organizations",4,3);
				
				//login to the browser
				WebDriver driver=null;
				if(Browser.equalsIgnoreCase("Chrome")) {
					driver=new ChromeDriver();
				}
				else if(Browser.equalsIgnoreCase("Firefox")) {
					driver=new FirefoxDriver();
				}
				else {
					System.out.println("Invalid browser name");
				}
				wUtil.maximizeWindow(driver);
				wUtil.waitForPageLoad(driver);
				driver.get(URL);
				// step 4:Login the application
				LoginPage lp=new LoginPage(driver);
				lp.LoginToApp(USERNAME, PASSWORD);
				//Step 5: Navigate to Organizations Link
				HomePage hp=new HomePage(driver);
				hp.clickOnOrganizationLink();
				//Step 6: Click on Organizations look up image
				OrganizationsPage op=new OrganizationsPage(driver);
				op.clickOnCreateOrgLookUpImg();
				//Step 7: Create new organization and save
				CreatingNewOrganizationPage cnp=new CreatingNewOrganizationPage(driver);
				//cnp.createNewOrganization(ORGNAME);
				cnp.createNewOrganization(OrgName,Industry);;
				// Step 8: validate
				OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
				String OrgHeader=oip.getOrganizationHeader();
				if(OrgHeader.contains(OrgName)) {
				 System.out.println(OrgHeader+"--->pass");
				}
				else {
					System.out.println("Fail");
					
				}
				// Step 8: log out application
				hp.logoutOfApp(driver);
		
	}
	@DataProvider(name="OrgName")
		public Object[][] getdata() throws EncryptedDocumentException, IOException{
		
		Object[][] data=eUtil.readmultipleData("multipleOrg");
		return data;
		
	}

}
