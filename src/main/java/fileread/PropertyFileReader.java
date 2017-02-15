package fileread;

import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
	
	static Properties prop = new Properties();
	
	public static void main(String[] args){
		try{
			ClassLoader classLoader = PropertyFileReader.class.getClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream("config.properties");
			prop.load(inputStream);
			
			String javaVersion = prop.getProperty("java.version");
			System.out.println(javaVersion);
		}catch(Exception e){
			e.printStackTrace();
		}
	  
		 
	}

}
