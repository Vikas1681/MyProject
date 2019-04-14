package com.PacificPower.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	
	Properties prop;
	FileInputStream fileInputStream;
	
	public Properties readConfig() {
		File source = new File("./Configuration/config.properties");
		try {
		fileInputStream = new FileInputStream(source);
		prop = new Properties();
		prop.load(fileInputStream);
		}
		catch(FileNotFoundException fne) {
			System.out.println(fne.getMessage());
		}
		catch(IOException io) {
			io.getMessage();
		}
		return prop;
		
	}

}
