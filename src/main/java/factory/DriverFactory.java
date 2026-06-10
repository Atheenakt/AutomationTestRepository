package factory;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    WebDriver webdriver;
    public static ThreadLocal<WebDriver> threadLocalDriver=new ThreadLocal<>();

    /**
     * Initialize thread local driver based on browser
     * @param browser
     * @return This return thredalocal driver
     */
    public WebDriver init_driver(String browser)
    {
        System.out.println("Browser value is:"+browser);
        if(browser.equals("Chrome"))
        {
          WebDriverManager.chromedriver().setup();
          threadLocalDriver.set(new ChromeDriver());
        }
        else if (browser.equals("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            threadLocalDriver.set(new FirefoxDriver());
        }
        else if (browser.equals("Safari"))
        {
            WebDriverManager.safaridriver().setup();
            threadLocalDriver.set(new SafariDriver());
        }
        else
        {
            System.out.println("Please enter browser value correctly!!");
        }
       getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver()
    {
        return threadLocalDriver.get();
    }
}
