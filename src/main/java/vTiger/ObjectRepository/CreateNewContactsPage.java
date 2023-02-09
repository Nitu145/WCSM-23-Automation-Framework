package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilitity.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility {
	// declaration
		@FindBy(name = "lastname")
		private WebElement lastNameEdt;

		@FindBy(name = "leadsource")
		private WebElement leadSourceDropDown;

		@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
		private WebElement OrganizationImg;

		@FindBy(name = "search_text")
		private WebElement searchEdt;

		@FindBy(name = "search")
		private WebElement searchBtn;

		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;

		// initialization
		public CreateNewContactsPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}

		// Utilization
		public WebElement getLastNameEdt() {
			return lastNameEdt;
		}

		public WebElement getLeadSourceDropDown() {
			return leadSourceDropDown;
		}

		public WebElement getOrganizationImg() {
			return OrganizationImg;
		}

		public WebElement getSearchEdt() {
			return searchEdt;
		}

		public WebElement getSearchBtn() {
			return searchBtn;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}

		
		//Business Library
		/**
		 * This method will create contact with mandatory fields
		 * @param lastname
		 */
		public void createNewContact(String lastname)
		{
			lastNameEdt.sendKeys(lastname);
			saveBtn.click();
		}
		
		/**
		 * This method will create contact with organization
		 * @param driver
		 * @param LastName
		 * @param OrgName
		 */
		public void createNewContact(WebDriver driver,String LastName, String OrgName)
		{
			lastNameEdt.sendKeys(LastName);
			OrganizationImg.click();
			switchToWindow(driver, "Accounts");
			searchEdt.sendKeys(OrgName);
			searchBtn.click();
			driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
			switchToWindow(driver, "Contacts");
			saveBtn.click();
			
			
		}
		
		
		
		
		
		
		
		
		
		
		

}
