package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
    public Properties getProperty() throws IOException
    {
    	FileInputStream inputStream = null;
    	Properties properties = new Properties();
    	try
    	{
    		properties.load(new FileInputStream("resources/data.properties"));
    	}catch(Exception e ) {
    		System.out.println("Exception :"+e);
    	}
		return properties;
    	
    }
}
