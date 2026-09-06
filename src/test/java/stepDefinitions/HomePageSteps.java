package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;

import java.util.List;

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

    @Then("user validates options displayed in top right of the page")
    public void userValidatesOptionsDisplayedInTopRightOfThePage() {
        homePage.validateHomePageOptions();
    }

    @When("user click on MyAccountOption")
    public void userClickOnMyAccountOption() {
        homePage.clickOnMyAccount();
    }

    @Then("user validate options displayed for MyAccount")
    public void userValidateOptionsDisplayedForMyAccount() {
        homePage.validateMyAccountOptions();
    }

    @When("user click on currency and selects {string}")
    public void userClickOnCurrencyAndSelects(String currency) {
        homePage.clickOnCurrencyAndChooseCurrency(currency);
    }

    @Then("user validates product price is updated with {string}")
    public void userValidatesProductPriceIsUpdatedWith(String currency) {
        List<WebElement> priceListfromUI=homePage.capturePriceValues();
        String currencySymbol=currency.substring(0,1);
        for(WebElement price:priceListfromUI)
        {
            System.out.println("price is:"+price.getText());
            Assert.assertTrue(price.getText().contains(currencySymbol));
        }
    }

    @When("user clicks on LOB product {string}")
    public void userClicksOnLOBAndChoose(String product) {
        homePage.chooseProductFromLOB(product);
    }

    @When("user choose product {string}")
    public void userChooseProduct(String productClassification) {
        if(productClassification!="NA")
         homePage.chooseProductFromDropdown(productClassification);
    }

    @Then("user validates featured area present and products are displayed")
    public void userValidatesFeaturedOptionIsAvailableInTheBottomOfThePage() {
        homePage.validateFeaturedSection();
    }

    @Then("user Validates available buttons for featured products")
    public void userValidatesAvailableButtonsForFeaturedProducts() {
        homePage.validateFeaturedProductsAndButtons();
    }

    @Then("user validates advertisements of home page")
    public void userValidatesFootersOfHomePage() {
        homePage.advertisementValidation();
    }
}
