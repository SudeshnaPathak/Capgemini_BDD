package StepDefinitions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonAddToCartTest {
	static WebDriver driver;
	static String parentId;
	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   driver.get("https://www.amazon.in/?ref_=icp_country_from_us");
	   parentId = driver.getWindowHandle();
	}
	@When("User searches for {string}")
	public void user_searches_for_headphones(String serachItem) {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(serachItem, Keys.ENTER);
	}
	@When("User selects the first product")
	public void user_selects_the_first_product() {
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
	}
	@When("User clicks on Add to Cart button")
	public void user_clicks_on_add_to_cart_button() {
		Set<String> ids = driver.getWindowHandles();
		ids.remove(parentId);
		String childId = ids.iterator().next();
		driver.switchTo().window(childId);
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click();
		
	}
	@Then("Product should be added to the cart-verify text of added to cart using isDisplayed")
	public void product_should_be_added_to_the_cart_verify_text_of_added_to_cart_using_is_displayed() {
		driver.findElement(By.xpath("//h1[contains(text(),'Added to cart')]")).isDisplayed();
		driver.quit();
	}

}
