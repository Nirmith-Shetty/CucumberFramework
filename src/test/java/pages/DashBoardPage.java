package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    WebDriver driver;

    public DashBoardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
    WebElement customersMenuOption;

    @FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
    WebElement customersLink;



    public void clickOnCustomersMenuOption(){
        customersMenuOption.click();
    }

    public void clickOnCustomersLink(){
        customersLink.click();
    }


}
