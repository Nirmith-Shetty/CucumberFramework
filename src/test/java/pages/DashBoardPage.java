package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage{


    @FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
    WebElement customersMenuOption;

    @FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
    WebElement customersLink;

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnCustomersMenuOption(){
        customersMenuOption.click();
    }

    public void clickOnCustomersLink(){
        customersLink.click();
    }


}
