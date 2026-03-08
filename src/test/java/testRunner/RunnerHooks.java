package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/hooksFeature/HooksDemo.feature"},
glue = "StepsForHooks",
dryRun = false)
public class RunnerHooks extends AbstractTestNGCucumberTests{

}
