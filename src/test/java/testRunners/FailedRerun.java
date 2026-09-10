package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"@target/failedRun.txt"},
            glue     ={ "stepDefinitions", "AppHooks"},
            plugin   = {
                    "pretty",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                    "timeline:test-output-thread/",
                    "rerun:target/failedRun.txt"
            }
    )
    public class FailedRerun {
    }


