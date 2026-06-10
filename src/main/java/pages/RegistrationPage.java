package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;
    private By first_Name= By.id("input-firstname");
    private By last_Name= By.id("input-lastname");
    private By emailID= By.id("input-email");
    private By telephoneNum= By.id("input-telephone");
    private By password= By.id("input-password");
    private By confirmpassword= By.id("input-confirm");
    private By yesRadioButton= By.xpath("//input[@name='newsletter' and @value='1']");
    private By noRadioButton= By.xpath("//input[@name='newsletter'][@value='1']");
    private By privacyPolicyCheckBox=By.xpath("//input[@name='agree'][@value='1']");
    private By continueButton= By.xpath("//input[@type='submit'][@value='Continue']");
    private By registerAccountLabel= By.xpath("//h1[text()='Register Account']");
    private By registerLink=By.linkText("Register");

    public RegistrationPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getTitle()
    {
        return driver.getTitle();
    }
    public void enterRegistrationDetails(String firstname,String lastName,String email,String telephone,String pwd)
    {
        driver.findElement(first_Name).sendKeys(firstname);
        driver.findElement(last_Name).sendKeys(lastName);
        driver.findElement(emailID).sendKeys(email);
        driver.findElement(telephoneNum).sendKeys(telephone);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmpassword).sendKeys(pwd);
    }

    public void clickOnYesRadioButton()
    {
        driver.findElement(yesRadioButton).click();
    }
    public void clickOnNoRadioButton()
    {
        driver.findElement(noRadioButton).click();
    }
    public void clickOnPrivacyPolicyCheckbox()
    {
        driver.findElement(privacyPolicyCheckBox).click();
    }
    public void clickOnContinueButton()
    {
        driver.findElement(continueButton).click();
    }
    public void validateRegisterAccountPage()
    {
        driver.findElement(registerAccountLabel).isDisplayed();
        driver.findElement(registerLink).isDisplayed();
    }
}

