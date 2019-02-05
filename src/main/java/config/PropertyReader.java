package config;

import org.openqa.selenium.By;

import java.io.*;
import java.util.Properties;

public class PropertyReader {
    private static String PATH_TO_UI_MAPPING = "src/main/resources/UIMapping.properties";
    private static String PATH_TO_DATA = "src/main/resources/data.properties";
    private static FileInputStream fis;
    private static Properties properties;

    private enum LocatorType{
        id, name, css, xpath, tag, text, partText;
    }

    private static void loadProperties(String path){
        try {
            fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getData(String dataName){
        loadProperties(PATH_TO_DATA);
        return properties.getProperty(dataName);
    }

    public static By getLocator(String locatorName){
        loadProperties(PATH_TO_UI_MAPPING);
        String locator = properties.getProperty(locatorName);
        String[] locatorItems = locator.split(":",2);
        LocatorType locatorType = LocatorType.valueOf(locatorItems[0]);
        switch(locatorType) {

            case id :{
                return By.id(locatorItems[1]);
            }

            case name:{
                return By.name(locatorItems[1]);
            }

            case css:{
                return By.cssSelector(locatorItems[1]);
            }

            case xpath:{
                return By.xpath(locatorItems[1]);
            }

            case tag:{
                return By.tagName(locatorItems[1]);
            }

            case text:{
                return By.linkText(locatorItems[1]);
            }

            case partText:{
                return By.partialLinkText(locatorItems[1]);
            }

            default:{
                throw new IllegalArgumentException("No such locator type: " + locatorItems[0]);
            }
        }
    }
}
