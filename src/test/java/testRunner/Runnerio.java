package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/featureFile/ddt.feature"},
glue = "StepDefinitions",
//monochrome = true,
//plugin = {"pretty" , "json:target/JsonReports/report.json"},
tags = "@Regression",
dryRun = false)
public class Runnerio extends AbstractTestNGCucumberTests{

}
