package StepDefinition;

import Driver.DriverManager;
import Utils.PropertiesUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
    public void takeScreenShotOnFailure(Scenario scenario) {
        if(scenario.isFailed()){
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
        DriverManager.quit();
    }


}
