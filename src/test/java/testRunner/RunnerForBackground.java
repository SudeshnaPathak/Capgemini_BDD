package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/background/BackgroundDemo.feature"},
glue = "StepDefinitions",
dryRun = false)
public class RunnerForBackground extends AbstractTestNGCucumberTests{

}
