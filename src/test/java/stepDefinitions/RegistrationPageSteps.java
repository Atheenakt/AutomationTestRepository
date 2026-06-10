package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RegistrationPage;

public class RegistrationPageSteps {

    private RegistrationPage registrationPage=new RegistrationPage(DriverFactory.getDriver());

    @Then("validates user is the on the register account page")
    public void validates_user_is_the_on_the_register_account_page() {
        registrationPage.validateRegisterAccountPage();
    }

    @When("user submit with all the mandatory details {string} {string} {string} {string} {string}")
    public void user_submit_with_all_the_mandatory_details(String firstname, String lastName, String email, String telephone, String pwd) {
        registrationPage.enterRegistrationDetails(firstname, lastName, email, telephone, pwd);
    }

    @Then("user validates the title of the page {string}")
    public void user_validates_title_of_the_page(String expected_title)
    {
        String actualTitle=registrationPage.getTitle();
        Assert.assertEquals(actualTitle,expected_title);
    }
    @When("user clicks on subscribe Option {string}")
    public void user_clicks_on_subscribe_Option(String subscribeOption) {
        if (subscribeOption.equals("Yes"))
            registrationPage.clickOnYesRadioButton();
        else
            registrationPage.clickOnNoRadioButton();
    }

    @When("user clicks on privacy policy checkbox")
    public void user_clicks_on_privacy_Policy_checkbox() {
        registrationPage.clickOnPrivacyPolicyCheckbox();
    }

    @When("user clicks on continue button")
    public void user_clicks_on_continue_button() {
        registrationPage.clickOnContinueButton();
    }

    @Then("User validates account created successfully")
    public void user_validates_account_created_successfully() {
        throw new io.cucumber.java.PendingException();
    }

}
