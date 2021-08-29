package com.vtiger.vd.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This method is used to read the data from property file
 * @author Vidyadhara
 *
 */
public class FileUtility {
	
	/**
	 * This method is used to read the data from property file by passing key as a argument
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/commonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;

	}

}
