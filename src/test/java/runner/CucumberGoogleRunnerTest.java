package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/cucumber.feature",
        glue = "stepdefinitions"
)

public class CucumberGoogleRunnerTest {
}
