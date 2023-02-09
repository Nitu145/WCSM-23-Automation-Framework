package vTiger.GenericUtilitity;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/*
 * This class provides implementation to all the methods in ITestListernals Interface oh TestNG
 * 
 */

public class ListenersImplementationClass implements ITestListener{
	ExtentReports reports;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//System.out.println("--------"+methodName+"---Test Script Pass------");
		//System.out.println(result.getMethod().getAttributes());
		test= reports.createTest(methodName);
		test.log(Status.INFO, "Test Execution started: " + methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//System.out.println("--------"+methodName+"---Test Script Pass------");
		test.log(Status.PASS, "Test Script Passed- " + methodName);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wUtil=new WebDriverUtility();
		javaUtility jUtil=new javaUtility();
		String methodName = result.getMethod().getMethodName();
		//System.out.println("--------"+methodName+"---Test Script Failed------");
		test.log(Status.FAIL, "Test Script failed - " + methodName);
		test.log(Status.FAIL, result.getThrowable());
		//System.out.println(result.getThrowable());
		
		String screenshotName = methodName+"-"+jUtil.getSystemDate();
		 try {
			wUtil.takeScreenShot(BaseClass.sdriver,screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//System.out.println("--------"+methodName+"---Test Script Skipped------");
		//System.out.println(result.getThrowable());
		test.log(Status.SKIP, "Test Script skipped- " + methodName);
		test.log(Status.SKIP, result.getThrowable());
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("----Suite Execution started----");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new javaUtility().getSystemDateInFormate() + ".html");
		htmlReport.config().setDocumentTitle("VTiger Execution Report");
		htmlReport.config().setReportName("VTiger Suite Execution");
		htmlReport.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Base URL", "http://localhost:8888/");
		reports.setSystemInfo("Base Browser", "Chrome");
		reports.setSystemInfo("Base OS", "Windows");
		reports.setSystemInfo("Reporter Name", "Nitu");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("----Suite Execution Finished----");
		reports.flush();
	}
	
	
	

}
