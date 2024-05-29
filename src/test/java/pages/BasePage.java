package pages;

import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }


    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //method overloading
    public void waitForElement(WebElement element,String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }


    public void switchToWindow(){
        String parentWindow = driver.getWindowHandle();
        Set<String> windows=driver.getWindowHandles();

        for(String window:windows){
            if(!window.equalsIgnoreCase(parentWindow)){
                driver.switchTo().window(window);
            }
        }
    }


    public void selectFromDropDown(String option, WebElement element){
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }









}
