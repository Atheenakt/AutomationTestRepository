package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    private By myAccount=By.xpath("//a[@title='My Account']");
    private By registerOption=By.linkText("Register");
    private By loginOption=By.linkText("Login");
    private By featured=By.xpath("//*[text()='Featured']");
    private By cartButton=By.id("cart");


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
        driver.findElement(registerOption).click();
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
}
