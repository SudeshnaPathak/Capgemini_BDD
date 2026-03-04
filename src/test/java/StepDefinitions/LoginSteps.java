package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	static WebDriver driver;
	
	@Given("browser is launched")
	public void browser_is_launched() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println("Blank chrome window is launched");
	}
	@When("user is on login page")
	public void user_is_on_login_page() {
		driver.get("http://49.249.28.218:8098/");
	}
	@When("user enters {string} and {string} and clicks on login button")
	public void user_enters_username_and_password_and_clicks_on_login_button(String username, String password) {
		 driver.findElement(By.id("username")).sendKeys(username , Keys.TAB, password, Keys.ENTER);
	}
	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() throws InterruptedException {
	   driver.findElement(By.xpath("//a[text()='Dashboard']")).isEnabled();
	   Thread.sleep(2000);
	   driver.quit();
	}
}
