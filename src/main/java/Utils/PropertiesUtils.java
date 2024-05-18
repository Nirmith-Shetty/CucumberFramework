package Utils;

import constants.Path;

import java.io.FileInputStream;
import java.util.Properties;


public class PropertiesUtils {

    Properties properties;

    String path = Path.CONFIG_PROPERTIES_PATH;


    public void loadProperties(){
        try {
            properties = new Properties();
            //to open config .properties file in input mode and load the file
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String get(String key){
        return properties.getProperty(key);
    }

}
