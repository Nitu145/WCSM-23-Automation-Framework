package vtigerOrganizationTestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilitity.ExcelFileUtility;
import vTiger.GenericUtilitity.PropertyFileUtility;
import vTiger.GenericUtilitity.WebDriverUtility;
import vTiger.GenericUtilitity.javaUtility;
import vTiger.ObjectRepository.LoginPage;

public class CreateOrgWithIndutstryAndTypeWithDDTandGUTest {
	@Test
	public void createordWithIndustryAndTypeTest() throws IOException {
		//Step 1: create the oject of all requierd classes/utility
		javaUtility jUtil = new javaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
	    PropertyFileUtility pUtil = new PropertyFileUtility();
	    ExcelFileUtility eUtil = new ExcelFileUtility();
	    //Step 2: Read the data from proprty and excel file
	     String BROWSER = pUtil.readDataFromPropertyFile("browser");
	    String URL = pUtil.readDataFromPropertyFile("url");
	    String USERNAME = pUtil.readDataFromPropertyFile("username");
	    String PASSWORD = pUtil.readDataFromPropertyFile("password");
	    //execl
	    String ORG = eUtil.readDataFromExcelFile("Organizations", 10, 2)+jUtil.getRandomNumber();
	    String INDUSTRY = eUtil.readDataFromExcelFile("Organizations", 10, 3);
	    String TYPE = eUtil.readDataFromExcelFile("Organizations",10, 4);
	    //Step 3: launch Browser
	    WebDriver driver=null;
	    if(BROWSER.equalsIgnoreCase("chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox")) {
	    	WebDriverManager.chromedriver().setup();
	    	driver=new FirefoxDriver();
	    }
	    else {
	    	System.out.println("Invalid Browser");
	    }
	    wUtil.maximizeWindow(driver);
	    wUtil.waitForPageLoad(driver);
	    driver.get(URL);
	    //Step 4: Login to application
	    LoginPage lp = new LoginPage(driver);
	    lp.LoginToApp(USERNAME, PASSWORD);
	    //Step 5: Click on Navigate to Organization link
	    driver.findElement(By.linkText("Organizations")).click();
	    //Step 6: click on Organization Look up Images
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    //Step 7: Create organization 
	    driver.findElement(By.name("accountname")).sendKeys(ORG);
	    //Step 8: Select Industry
	    WebElement ELEMENT = driver.findElement(By.name("industry"));
	    wUtil.handleDropDown(INDUSTRY, ELEMENT);
	    WebElement typeEle = driver.findElement(By.name("accounttype"));
	    wUtil.handleDropDown(TYPE,typeEle);
	    //Step 9: save 
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    //validate 
	    String ORGHEADER = driver.findElement(By.className("dvHeaderText")).getText();
	    if(ORGHEADER.contains(ORG))
		{
			System.out.println(ORGHEADER+" pass");
		}
		else {
			System.out.println(ORGHEADER+" Fail");
		}
	    // logout
	    WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    wUtil.mouseHoverAction(driver,element);
	    driver.findElement(By.linkText("Sign Out")).click();
	    
	}

}
