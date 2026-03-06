package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	protected WebDriver driver;
	private By txt_username = By.id("username");
	private By txt_password = By.id("inputPassword");
	private By btn_login = By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		if(!driver.getTitle().equals("Ninza CRM"))
		{
			throw new IllegalStateException("This is not login page. The current page is " + driver.getTitle());
		}
	}
	
	public void enterUsername(String username)
	{
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clickLogin()
	{
		driver.findElement(btn_login).click();
	}
	
	public void loginValidUser(String username, String password)
	{
		driver.findElement(txt_username).sendKeys(username, Keys.TAB, password, Keys.ENTER);
	}
}
