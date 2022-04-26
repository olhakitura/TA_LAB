package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesReader {
    final static Logger logger= Logger.getLogger("PropertiesReader.class");
    Properties property = new Properties();

    public PropertiesReader(){
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            fis.close();
        } catch (IOException e) {
            logger.info("Properties file is not found!");
        }
    }

    public String getUrl(){
        String URL = property.getProperty("URL");
        return URL;
    }

    public String getNewUrl(){
        String NEW_URL = property.getProperty("NEW_URL");
        return NEW_URL;
    }



}
