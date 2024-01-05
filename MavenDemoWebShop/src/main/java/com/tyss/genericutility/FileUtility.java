package com.tyss.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	
	public String getfromProperty(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/testData/commonData.properties");
		
		Properties prop=new Properties();
		
		prop.load(fis);
		return prop.getProperty(key);
	}
}
