package vTigerContactTestScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilitity.BaseClass;
@Listeners(vTiger.GenericUtilitity.ListenersImplementationClass.class)
public class DemoTest extends BaseClass {
	@Test
	public void demoTest() throws InterruptedException
	{
		System.out.println("Demo");
		Thread.sleep(2000);
	}
	
	@Test
	public void sampleTest() throws InterruptedException {
		System.out.println("Smaple");
		Thread.sleep(2000);
		Assert.fail();
		Thread.sleep(2000);
	}

}
