package vTiger.GenericUtilitity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	/**
	 * This method will Read Data from Property File and return the value.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.PropertyFilepath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
	
	}

	public String readDataFromExcel(String string, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

}
