package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CustomerPage extends BasePage {

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/Admin/Customer/Create']")
    WebElement addNewButton;

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(id = "FirstName")
    WebElement firstNameField;

    @FindBy(id = "LastName")
    WebElement LastNameField;

    @FindBy(id = "Gender_Male")
    WebElement maleGenderRadioButton;

    @FindBy(id = "Gender_Female")
    WebElement femaleGenderRadioButton;

    @FindBy(id = "DateOfBirth")
    WebElement dob;

    @FindBy(id = "Company")
    WebElement companyName;

    @FindBy(id = "IsTaxExempt")
    WebElement taxExemptCheckbox;

    @FindBy(xpath = "//button[@name='save']")
    WebElement saveButton;


    @FindBy(xpath = "//div[contains(@class,'alert')]")
    WebElement savedSuccessfullyAlert;


    public void clickOnAddNew(){
        addNewButton.click();
    }


    public void enterAllDetails(){
        waitForElement(emailField);
        emailField.sendKeys("HHww@gmail.com");
        passwordField.sendKeys("2849494");
        firstNameField.sendKeys("Nitmith");
        LastNameField.sendKeys("ajdsjdas");
        maleGenderRadioButton.click();
        dob.sendKeys("06/07/1996");
        companyName.sendKeys("XYZ");
        taxExemptCheckbox.click();
    }

    public void enterAllDetails(Map<String, String> data){
        emailField.sendKeys(data.get("Email"));
        passwordField.sendKeys("2849494");
        firstNameField.sendKeys(data.get("Name"));
        LastNameField.sendKeys("ajdsjdas");
        maleGenderRadioButton.click();
        dob.sendKeys("06/07/1996");
        companyName.sendKeys("XYZ");
        taxExemptCheckbox.click();
    }

    public void clickOnSave(){
        saveButton.click();
    }


    public String getSavedSuccessText(){
        return savedSuccessfullyAlert.getText();
    }

}
