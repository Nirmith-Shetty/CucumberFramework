package StepDefinition;

import Driver.DriverManager;
import Utils.ExcelReader;
import Utils.PropertiesUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CustomerPage;
import pages.DashBoardPage;
import pages.LoginPage;
import java.util.Map;

public class CustomerStepDefinition {
    WebDriver driver = DriverManager.getInstance();
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    CustomerPage customerPage;

    PropertiesUtils propertiesUtils = new PropertiesUtils();

    @Given("User is logged in and on home page")
    public void user_is_logged_in_and_on_home_page() {
        loginPage = new LoginPage(driver);
        propertiesUtils.loadProperties();
        loginPage.enterUsername(propertiesUtils.get("username"));
        loginPage.enterPassword(propertiesUtils.get("password"));
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getTitleOfLoginPage(), "Dashboard / nopCommerce administration");
    }

    @When("user clicks on customers option on left menu")
    public void user_clicks_on_customers_option_on_left_menu() {
        dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.clickOnCustomersMenuOption();

    }
    @When("clicks on customers option")
    public void clicks_on_customers_option() {
        dashBoardPage.clickOnCustomersLink();

    }
    @Then("customer page should open")
    public void customer_page_should_open() {
        customerPage = new CustomerPage(driver);
        //Assert.assertTrue(customerPage.getSavedSuccessText().contains("The new customer has been added successfully."));
    }
    @Then("user clicks on Add new")
    public void user_clicks_on_add_new() {
        customerPage.clickOnAddNew();
    }
    @Then("user fills all the details")
    public void user_fills_all_the_details() {
        customerPage.enterAllDetails();
    }


    @Then("user fills all the details according the excel data for below mentioned {string} and {string} Sheet")
    public void user_fills_all_the_details_according_the_excel_data_for_below_mentioned_and_sheet(String testCaseID, String sheetName) {
        ExcelReader excelReader = new ExcelReader();
        Map<String, String> data = excelReader.getExcelData(Integer.parseInt(testCaseID),sheetName);
        customerPage.enterAllDetails(data);
    }

    @Then("clicks on save")
    public void clicks_on_save() {
        customerPage.clickOnSave();
        Assert.assertTrue(customerPage.getSavedSuccessText().contains("The new customer has been added successfully."));
    }

}
