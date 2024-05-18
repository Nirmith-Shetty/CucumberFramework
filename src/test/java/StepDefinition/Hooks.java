package StepDefinition;

import Driver.DriverManager;
import Utils.PropertiesUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;
    PropertiesUtils propertiesUtils;

    @Before
    public void setup() {
        driver = DriverManager.getInstance();
        propertiesUtils = new PropertiesUtils();
        propertiesUtils.loadProperties();
        driver.get(propertiesUtils.get("url"));
    }


    @After
    public void tearDown() {
        DriverManager.quit();
    }

}
