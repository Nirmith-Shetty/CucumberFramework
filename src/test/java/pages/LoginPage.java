package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    //Page Factory
    @FindBy(id = "Email")
    WebElement username;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(tagName = "button")
    WebElement loginButton;

    @FindBy(id = "Email-error")
    WebElement wrongEmailError;


    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement incorrectCredentialsErrorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void enterUsername(String email){
        username.clear();
        username.sendKeys(email);
    }

    public void enterPassword(String pass){
        password.clear();
        password.sendKeys(pass);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public String getWrongEmailErrorMessage(){
      return wrongEmailError.getText();
    }

    public String getIncorrectCredentialsErrorMessage(){
        return incorrectCredentialsErrorMsg.getText();
    }

    public String getTitleOfLoginPage(){
        return driver.getTitle();
    }


}
