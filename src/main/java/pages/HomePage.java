package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
    private final By featuredProductImage=By.xpath("//div[@id='content']//div[@class='image']");
    private final By featuredProductCaption=By.xpath("//div[@id='content']//div[@class='caption']");
    private final By featuredProductAddToCart=By.xpath("//span[text()='Add to Cart']//parent ::button");
    private final By featuredProductWishList=By.xpath("//button[@data-toggle='tooltip' and @data-original-title='Add to Wish List']");
    private final By featuredProductCompare=By.xpath("//button[@data-toggle='tooltip' and @data-original-title='Compare this Product']");
    private final By advertisementSection=By.xpath("//div[@id='carousel0']");
    private final By advertisedImages =By.xpath("//div[@id='carousel0' and @class='swiper-container swiper-container-horizontal']//div//img[@class='img-responsive']");
    private final By previousSwipeButton=By.xpath("//div[@class='carousel swiper-viewport']//div[@class='swiper-button-prev']");
    private final By nextSwipeButton=By.xpath("//div[@class='carousel swiper-viewport']//div[@class='swiper-button-next']");
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
        //final By productFromDropdown=By.xpath("//button[text()='"+currency+"']");
        driver.findElement(currencyButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='"+currency+"']")));
        element.click();
    }

    public List<WebElement> capturePriceValues() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
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

    public void validateFeaturedSection() {
        driver.findElement(featured).isDisplayed();
        driver.findElement(featuredProductImage).isDisplayed();
        driver.findElement(featuredProductCaption).isDisplayed();
    }

    public void validateFeaturedProductsAndButtons() {
        driver.findElement(featuredProductAddToCart).isDisplayed();
        driver.findElement(featuredProductWishList).isDisplayed();
        driver.findElement(featuredProductCompare).isDisplayed();
    }

    public void advertisementValidation() {
        WebElement advertisementSect=driver.findElement(advertisementSection);
        Actions actions = new Actions(driver);
        actions.moveToElement(advertisementSect).perform();
        driver.findElement(advertisedImages).isDisplayed();
        driver.findElement(previousSwipeButton).isDisplayed();
        driver.findElement(nextSwipeButton).isDisplayed();
    }
}
