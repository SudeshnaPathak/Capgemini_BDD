package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/hooksFeature/HooksDemo.feature"},
glue = "StepDefinitions",
plugin = {"json:target/jsonReports/cucumber.json"},
dryRun = false)
public class TestRunnerHooks extends AbstractTestNGCucumberTests{

}
