package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;

public class HomePageSteps {
    private HomePage homePage=new HomePage(DriverFactory.getDriver());
    @Given("User is on the home Page of Automation labs")
    public void user_is_on_the_home_page_of_automation_labs() {
        DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/");
        String title=homePage.getTitle();
        Assert.assertEquals(title,"Your Store");
        String currentUrl=homePage.getPageURL();
        Assert.assertEquals(currentUrl,"https://naveenautomationlabs.com/opencart/");
        homePage.validateHomePage();
    }

    @When("user clicks on registration button from My Account Option")
    public void user_clicks_on_registration_button_from_my_account_option() {
      homePage.clickOnMyAccount();
      homePage.clickOnRegister();
    }

    @When("user clicks on login button from My Account Option")
    public void user_clicks_on_login_button_from_my_account_option() {
        homePage.clickOnMyAccount();
        homePage.clickOnLogin();
    }

    @When("validates user is the on the login page")
    public void user_is_on_the_login_page() {

    }
}
