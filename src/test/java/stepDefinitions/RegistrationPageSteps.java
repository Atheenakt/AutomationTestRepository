package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RegistrationPage;
import utils.ExcelReader;

import java.io.IOException;

public class RegistrationPageSteps {

    private RegistrationPage registrationPage=new RegistrationPage(DriverFactory.getDriver());
    ExcelReader excelReader=new ExcelReader();
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

    @When("user click on hello button")
    public void user_click_on_hello_button() {
        throw new io.cucumber.java.PendingException();
    }

    @Then("User validates account created successfully")
    public void user_validates_account_created_successfully() {
        throw new io.cucumber.java.PendingException();
    }


    @When("user enter the details from Excel sheet in registration page {string} {int}")
    public void user_enter_the_details_from_excel_sheet_in_registration_page(String sheetName, Integer rowNumber) throws IOException {
        excelReader.openExcel("src/test/resources/testData/TestDataSheet.xlsx",sheetName);
        String firstName=excelReader.getCellData(rowNumber,"Firstname");
        String lastName=excelReader.getCellData(rowNumber,"Lastname");
        String email=excelReader.getCellData(rowNumber,"Email");
        String telephone=excelReader.getCellData(rowNumber,"Telephone");
        String pwd=excelReader.getCellData(rowNumber,"Password");
        System.out.println("Fields are:"+firstName+" ,"+"Lastname"+","+email);
        registrationPage.enterRegistrationDetails(firstName, lastName, email, telephone, pwd);
    }
}
