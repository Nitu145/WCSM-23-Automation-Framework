package vTiger.GenericUtilitity;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class BaseClass {
/**
 * This class contains all the basic configuration annotations
 * @author Chaitra M
 *
 */
	public javaUtility jUtil = new javaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver;//This is use for taking screnshot
	
	@BeforeSuite(groups = {"smokesuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("==== Database Connection successful ====");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"smokesuite","RegressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			sdriver=driver;
			System.out.println("===="+BROWSER+" Launch successful=====");

		} else if (BROWSER.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			sdriver=driver;
			System.out.println("===="+BROWSER+" Launch successful=====");

		} else {
			System.out.println("invalid browser name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
	}
	
	@BeforeMethod(groups = {"smokesuite","RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		System.out.println("==== login successful =====");
	}
	
	@AfterMethod(groups = {"smokesuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("==== logout successful ====");
	}
	//@AfterTest
	@AfterClass(groups = {"smokesuite","RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("==== browswer Closed =====");
	}
	
	
	
	@AfterSuite(groups = {"smokesuite","RegressionSuite"})
	public void asConfig()
	{
		System.out.println("==== Database Connection closed ====");
	}

}
