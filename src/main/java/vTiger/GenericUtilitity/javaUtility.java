package vTiger.GenericUtilitity;

import java.util.Date;
import java.util.Random;
//comment
/*- multiline comment*/
/**
 *  This class consists of generic methods related to java. 
 * @author Dell
 *
 */
 
public class javaUtility { 
	/**
	 * This method will generates a random number for every run.
	 * @return
	 */
	public int getRandomNumber() {
		Random r=new Random();
		int value = r.nextInt(10000);
		return value;
	}
	
	/**
	 * This method will return the date in specific formate.
	 * @author Dell
	 */
	public String getSystemDate() {
		Date d = new Date();
		String value = d.toString();
		return value;
	}
	/**
	 * This method will return the date in specific formate
	 * @return
	 */
	
	public String getSystemDateInFormate() {
		Date d = new Date();
	    String[] dArr = d.toString().split("");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String dateInformate=date+"_"+month+"_"+year+"_"+time;
		return dateInformate;
	}
	
}
