package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/featureFiles/AddToCart.feature"},
glue = "StepDefinitions",
//tags = "@smoke or @regression and @important",
//tags = "@regression and not @smoke",
//tags = "(@smoke or @regression) and not @important",
//tags = "@mustRun", //tags inheritance : Tags placed above parent are inherited by it's child, i.e tags above feature are inherited by Scenario, Scenario Outline, Examples
plugin = {"json:target/jsonReports/cucumber.json"},
dryRun = false)
public class TestRunnerSingleTags extends AbstractTestNGCucumberTests{

}

//Tips: Different Runners for different combinations of tags
