package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.HomePageFactory;
import pagefactory.LoginPageFactory;

public class LoginDemoStepPageFactory {
	
	WebDriver driver = null;
	LoginPageFactory login;
	HomePageFactory home;
	
	
	@Given("browser is launched")
	public void browser_is_launched() {
		System.out.println("Page Factory Implementations");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		login = new LoginPageFactory(driver);
		home = new HomePageFactory(driver);
	}
	
	@When("user is on login page")
	public void user_is_on_login_page() {
		driver.get("http://49.249.28.218:8098/");
	}
	
	@When("user enters {string} and {string} and clicks on login button")
	public void user_enters_username_and_password_and_clicks_on_login_button(String username, String password) {
		login.loginValidUser(username, password);
	}
	
	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page(){
	   assertTrue(home.verifyHomePage());
	}
	
	@And("user performs logout")
	public void user_performs_logout()
	{
		home.logout();
		driver.quit();
	}
}
