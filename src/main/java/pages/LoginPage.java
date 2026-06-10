package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LoginPage {
    WebDriver driver;
    private By emailID = By.id("input-email");
    private By password = By.id("input-password");
    private By login = By.xpath("//input[@type='submit' and @value='Login']");
    // . Representing class and classname , a -> All the links - Similar to //div[@class='list-group']/a
    private By loginPageLinks = By.cssSelector(".list-group a");
    private By errorMsg = By.xpath("//*[@id='account-login']/div[1]");
    private By registerAccount = By.xpath("//strong[text()='Register Account']");
    private By continueButton = By.linkText("Continue");
    private By forgotPassword = By.linkText("Forgotten Password");
    private By loginPageAllOptions = By.xpath("//div[@class='list-group']/a");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmailPassword(String email, String pwd) {
        driver.findElement(emailID).sendKeys(email);
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLoginButton() {
        driver.findElement(login).click();
    }

    public String captureError() {
        return driver.findElement(errorMsg).getText();
    }

    public void validateRegisterContinueOptions() {
        driver.findElement(registerAccount).isDisplayed();
        driver.findElement(continueButton).isDisplayed();
    }

    public void validateForgotPasswordLink() {
        driver.findElement(forgotPassword).isDisplayed();

    }

    public int validateLoginPageOptions(List<String> options) {
        List<WebElement> allOptionsUI=driver.findElements(loginPageAllOptions);
        int optionsCountUI=allOptionsUI.size();
        for(String option: options) {
            driver.findElement(By.xpath(String.format("//div[@class='list-group']/a[text()='%s']",option))).isDisplayed();
        }
        return optionsCountUI;
    }
}
