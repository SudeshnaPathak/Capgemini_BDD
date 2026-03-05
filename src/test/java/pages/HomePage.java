package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	protected WebDriver driver;
	private By dashboard = By.xpath("//a[text()='Dashboard']");
	private By userIcon = By.xpath("//div[@class='user-icon']");
	private By logout = By.xpath("//div[@class='dropdown-item logout']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyHomePage()
	{
		return driver.findElement(dashboard).isDisplayed();
	}
	
	public void logout()
	{
		driver.findElement(userIcon).click();
		driver.findElement(logout).click();
	}
	
}
