package com.surveillance.utilitiy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertySingleton 
{
	private static PropertySingleton _instance = null;

	public Map<String, String> objProperties;

	private PropertySingleton() 
	{
		objProperties = new HashMap<String, String>();
	}

	//static method to create instance of Singleton class
	public static PropertySingleton getInstance() {
		if (_instance == null) {
			_instance = new PropertySingleton();
			try {
				_instance.loadAllProperties();
			} catch (FileNotFoundException e) {
				_instance = null;
				e.printStackTrace();
			} catch (IOException e) {
				_instance = null;
				e.printStackTrace();
			}
		}

		return _instance;
	}


	private void loadAllProperties() throws FileNotFoundException, IOException {

		File folder = new File(System.getProperty("user.dir") + System.getProperty("file.separator")
		+ "ObjectRepoProperties" + System.getProperty("file.separator"));

		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {

			Properties temp = new Properties();
			if (file.isFile()) {
				temp = new Properties();
				// System.out.println(file.getAbsolutePath());
				temp.load(new FileInputStream(file.getAbsolutePath()));
				Set<Object> keySet = temp.keySet();
				for (Object key : keySet) {
					objProperties.put((String) key, temp.getProperty((String) key));
				}
			}
		}

	}

	public String getValue(String key) {
		if (_instance != null && _instance.objProperties != null) {

			return _instance.objProperties.get(key);
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(PropertySingleton.getInstance().getValue("loginPage.userName"));
		System.out.println(PropertySingleton.getInstance().getValue("test1.userName"));
	}

}
