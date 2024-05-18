package Driver;

import Utils.PropertiesUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    static PropertiesUtils propertiesUtils = new PropertiesUtils();

    //singleton design pattern
    private DriverManager() {

    }

    public static WebDriver getInstance() {

        if (driver.get() == null) {
            propertiesUtils.loadProperties();
            driver.set(getDriver(propertiesUtils.get("browser")));
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get().manage().window().maximize();
        }

        return driver.get();
    }


    public static void quit() {
        driver.get().quit();
        driver.remove();
    }

    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
        }
        return null;
    }


}
