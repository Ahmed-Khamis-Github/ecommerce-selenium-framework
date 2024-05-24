package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"steps"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report/index.html",
                "json:target/cucumber-reports/Cucumber.json",

        }
)
public class TestRunner extends TestBase {




}

