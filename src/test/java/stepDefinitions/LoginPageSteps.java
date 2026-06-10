package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

import java.util.List;

public class LoginPageSteps {
    private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());

    @When("user enters email and password {string} {string}")
    public void user_enters_email_password(String email, String password) {
        loginPage.enterEmailPassword( email, password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginButton();
    }

    @When("user validates error message {string}")
    public void user_validates_error_message(String errormsg) {
        String expected_Error=loginPage.captureError();
        Assert.assertTrue(expected_Error.contains(errormsg));
    }

    @Then("user validates register Account and Continue button displayed")
    public void user_validates_registerAccount_continue_button() {
        loginPage.validateRegisterContinueOptions();
    }

    @And("user validates forgot password link is displayed")
    public void user_validates_forgot_link() {
        loginPage.validateForgotPasswordLink();
    }

    @And("user validates the different options in right side of the page")
    public void user_validates_LoginPage_Options(DataTable dataTable) {
        List<String> options=dataTable.asList();
        int optionCountFromUI=loginPage.validateLoginPageOptions(options);
        Assert.assertEquals(options.size(),optionCountFromUI);
    }
}
