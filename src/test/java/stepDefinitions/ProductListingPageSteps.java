package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import pages.ProductListingPage;

public class ProductListingPageSteps {
    private final ProductListingPage ProductListingPage=new ProductListingPage(DriverFactory.getDriver());

    @Then("user validates user navigated to product listing page")
    public void userValidatesUserNavigatedToProductListingPage() {
        ProductListingPage.validateProductListingPage();
    }

}
