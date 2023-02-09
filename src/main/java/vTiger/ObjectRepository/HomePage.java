package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilitity.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	//Declaration
	@FindBy(linkText ="Organizations")
	private WebElement OrganizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement ProductsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getOrganizationsLink() {
		return OrganizationLnk;
	}
	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//Business Libraries
	/**
	 * This method will click on Organizations Link
	 */
	public void clickOnOrganizationLink()
	{
		OrganizationLnk.click();
	}
	
	/**
	 * This method will click on Contacts Link
	 */
	public void clickOnContactsLink()
	{
		ContactsLnk.click();
	}
	
	/**
	 * This method will log out of the application
	 * @param driver
	 */
	public void logoutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver, AdministratorImg);
		SignOutLnk.click();
	}
	

}
