package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    // Wait for element to be visible
    public WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    // Wait for element to be clickable
    public WebElement waitForClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    // Wait for element to be present in DOM
    public WebElement waitForPresence(By locator) {

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
    }

    // Wait for element to disappear
    public boolean waitForInvisibility(By locator) {

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }

    // Wait for alert
    public void waitForAlert() {

        wait.until(
                ExpectedConditions.alertIsPresent()
        );
    }

    // Wait for title
    public boolean waitForTitle(String title) {

        return wait.until(
                ExpectedConditions.titleIs(title)
        );
    }

    // Wait for URL
    public boolean waitForUrl(String url) {

        return wait.until(
                ExpectedConditions.urlToBe(url)
        );
    }
}