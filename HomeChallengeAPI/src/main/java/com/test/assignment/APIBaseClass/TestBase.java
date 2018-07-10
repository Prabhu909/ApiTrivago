package com.test.assignment.APIBaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
public Properties properties;
	
	public TestBase() {
		try {
			properties = new Properties();
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/test/assignment/APIConfig/config.properties");
			properties.load(fileInputStream);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
