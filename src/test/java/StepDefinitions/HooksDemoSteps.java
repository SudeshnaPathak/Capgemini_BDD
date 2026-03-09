package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.HomePageFactory;
import pagefactory.LoginPageFactory;

public class HooksDemoSteps {
	WebDriver driver = null;
	LoginPageFactory login;
	HomePageFactory home;
	
	@Before(order=2) //Before Every Scenario
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		login = new LoginPageFactory(driver);
		home = new HomePageFactory(driver);
		System.out.println("Browser Setup Complete");
	}
	
	@Before(value="@smoke", order=1) //Hooks with Tags/Conditional Hook + order of execution for same hooks
	public void setup2()
	{
		System.out.println("I am inside SetUp 2");
	}
	
	@BeforeStep("@smoke") //before every step
	public void beforeSteps()
	{
		System.out.println("I am inside Before step");
	}
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		driver.get("http://49.249.28.218:8098/");
	}
	
	@When("user enters valid {string} and {string} and clicks on login button")
	public void user_enters_valid_username_and_password_and_clicks_on_login_button(String username, String password) {
		login.loginValidUser(username, password);
	}
	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		assertTrue(home.verifyHomePage());
	}
	
	@AfterStep("@regression") //after every step
	public void afterSteps()
	{
		System.out.println("I am inside After step");
	}
	
	@After() //After every Scenario
	public void tearDown()
	{
		driver.quit();
		System.out.println("Server shutdown");
	}
}
