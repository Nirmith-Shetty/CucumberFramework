package StepDefinition;

import Driver.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;


public class LoginStepDefinition {

    LoginPage loginPage =  new LoginPage(DriverManager.getInstance());

    @When("user enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("clicks on login")
    public void clicks_on_login() {
        loginPage.clickOnLoginButton();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        Assert.assertEquals(loginPage.getTitleOfLoginPage(), title);
    }

    @Then("error message should be displayed as {string}")
    public void error_message_should_be_displayed_as(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getWrongEmailErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Then("incorrect password error message should be displayed as {string} and {string}")
    public void incorrect_password_error_message_should_be_displayed_as_and(String expectedErrorMessage1, String expectedErrorMessage2) {
        String actualErrorMessage = loginPage.getIncorrectCredentialsErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage1 + "\n" + expectedErrorMessage2);
    }

}
