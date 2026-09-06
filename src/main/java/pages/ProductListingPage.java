package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListingPage {
    private final By productGroups=By.cssSelector("div.list-group");
    private final By listViewButton=By.id("list-view");
    private final By gridViewButton=By.id("grid-view");
    private final By sortByLabel=By.xpath("//label[@class='input-group-addon' and text()='Sort By:']");
    private final By showProductsLabel=By.xpath("//label[@class='input-group-addon' and text()='Sh:']");

    WebDriver driver;
    public ProductListingPage(WebDriver driver) {
        this.driver=driver;
    }

    public void validateProductListingPage() {
        driver.findElement(productGroups).isDisplayed();
        driver.findElement(listViewButton).isDisplayed();
        driver.findElement(gridViewButton).isDisplayed();
        driver.findElement(sortByLabel).isDisplayed();
        driver.findElement(showProductsLabel).isDisplayed();
    }
}
