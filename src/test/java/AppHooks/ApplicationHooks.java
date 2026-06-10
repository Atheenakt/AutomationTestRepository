package AppHooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.util.Properties;

public class ApplicationHooks {
    private DriverFactory driverfactory;
    private WebDriver driver;
    private ConfigReader configReader;
    private Properties prop;

    @Before(order = 0)
    public void getProperty()
    {
        configReader=new ConfigReader();
        prop=configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser()
    {
        String browserName=prop.getProperty("browser");
        driverfactory=new DriverFactory();
        driver=driverfactory.init_driver(browserName);

    }

   @After(order = 0)
    public void quitBrowser()
   {
       driver.quit();
   }
    @After(order = 1)
    public void tearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
           String screenshotname=scenario.getName().replaceAll("","");
           byte[] sourcePath=( (TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
           scenario.attach(sourcePath,"image/png",screenshotname);
        }




    }

}
