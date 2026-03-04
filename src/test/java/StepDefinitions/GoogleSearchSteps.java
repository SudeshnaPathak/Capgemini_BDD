package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	static WebDriver driver;
	
	@Given("browser is open")
	public void browser_is_open() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println("Blank chrome window is launched");
	}
	@Given("user is on google search page")
	public void user_is_on_google_search_page() {
		driver.get("https://google.com/");
		System.out.println("navigated to search page");
	}
	@When("user enters a text in search box and hits enter")
	public void user_enters_a_text_in_search_box_and_hits_enter() {
		driver.findElement(By.xpath("//textarea[@aria-label='Search']")).sendKeys("Automation step by step", Keys.ENTER);
	}
	
	@Then("user is navigated to search page")
	public void user_is_navigated_to_search_page() {
		System.out.println("Search Results open");
		driver.getPageSource().contains("Online Coures");
		driver.quit();
	}
}
