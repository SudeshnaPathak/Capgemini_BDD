package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/featureFiles/ddt.feature"},
glue = "StepDefinitions",
//monochrome = true,
//plugin = {"pretty" , "json:target/JsonReports/report.json"},
//tags = "@Regression",
plugin = {"json:target/jsonReports/cucumber.json"},
dryRun = false)
public class TestRunnerio extends AbstractTestNGCucumberTests{

}
