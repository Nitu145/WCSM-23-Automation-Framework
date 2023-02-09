package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilitity.WebDriverUtility;

public class CreatingNewOrganizationPage extends WebDriverUtility {
	//declaration
		@FindBy(name = "accountname")
		private WebElement OrgNameEdt;

		@FindBy(name = "industry")
		private WebElement industryDropDown;

		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;

		//initialization
		public CreatingNewOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getOrgNameEdt() {
			return OrgNameEdt;
		}

		public WebElement getIndustryDropDown() {
			return industryDropDown;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		//Business Library
		/**
		 * this method will create new organization and save.
		 * @param OrgName
		 */
		public void createNewOrganization(String OrgName)
		{
			OrgNameEdt.sendKeys(OrgName);
			saveBtn.click();
		}
		
		/**
		 * this method will create new organization with industry
		 * @param OrgName
		 * @param industry
		 */
		public void createNewOrganization(String OrgName,String industry)
		{
			OrgNameEdt.sendKeys(OrgName);
			handleDropDown(industryDropDown, industry);
			saveBtn.click();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
