package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features"},
glue = "StepDefinitions",
//monochrome = true,
//plugin = {"pretty" , "json:target/JsonReports/report.json"},
//tags = "@SmokeTest",
dryRun = false)
public class Runnerio extends AbstractTestNGCucumberTests{

}
