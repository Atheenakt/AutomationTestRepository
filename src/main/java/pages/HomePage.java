package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {
    WebDriver driver;
    private final By myAccount=By.xpath("//a[@title='My Account']");
    private final By registerOption=By.linkText("Register");
    private final By loginOption=By.linkText("Login");
    private final By featured=By.xpath("//*[text()='Featured']");
    private final By cartButton=By.id("cart");
    private final By phoneIcon=By.xpath("//ul[@class='list-inline']//a[contains(@href,'route=information/contact')]");
    private final By wishList=By.id("wishlist-total");
    private final By cartOption=By.xpath("//a[@title='Shopping Cart']");
    private final By checkoutOption=By.xpath("//a[@title='Checkout']");
    private final By currencyButton=By.xpath("//form[@id='form-currency']//button[contains(@class, 'dropdown-toggle')]");
    private final By productPrice=By.xpath("//p[@class='price']");

    WebElement dropdown_element;
    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public String getTitle()
    {
        return driver.getTitle();
    }

    public String getPageURL()
    {
        return driver.getCurrentUrl();
    }
    public void clickOnMyAccount()
    {
        driver.findElement(myAccount).click();
    }
    public void clickOnRegister()
    {
        WebElement register=driver.findElement(registerOption);
        driver.navigate().refresh(); //-->Added to Replicate StaleElementReference Exception
        register.click();
    }
    public void clickOnLogin()
    {
        driver.findElement(loginOption).click();
    }

    public void validateHomePage()
    {
        driver.findElement(featured).isDisplayed();
        driver.findElement(cartButton).isDisplayed();
    }

    public void validateHomePageOptions() {
        driver.findElement(phoneIcon).isDisplayed();
        driver.findElement(myAccount).isDisplayed();
        driver.findElement(wishList).isDisplayed();
        driver.findElement(cartOption).isDisplayed();
        driver.findElement(checkoutOption).isDisplayed();
    }

    public void validateMyAccountOptions() {
        driver.findElement(loginOption).isDisplayed();
        driver.findElement(registerOption).isDisplayed();
    }

    public void clickOnCurrencyAndChooseCurrency(String currency) {
        dropdown_element = driver.findElement(currencyButton);
        Select select = new Select(dropdown_element);
        select.selectByVisibleText(currency);
    }

    public List<WebElement> capturePriceValues() {
        return driver.findElements(productPrice);
    }

    public void chooseProductFromLOB(String product) {
        final By productLOB=By.xpath("//nav[@class='navbar']//a[text()='"+product+"']");
        driver.findElement(productLOB).click();
    }

    public void chooseProductFromDropdown(String productClassification) {
        final By productFromDropdown=By.xpath("//ul[@class='list-unstyled']//a[contains(text(),'"+productClassification+"')]");
        driver.findElement(productFromDropdown).click();
    }
}
