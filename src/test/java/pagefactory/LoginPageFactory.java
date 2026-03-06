package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageFactory {
	
	protected WebDriver driver;
	
	@FindBy(id="username")
	@CacheLookup
	private WebElement txt_username;
	
	@FindBy(id="inputPassword")
	@CacheLookup 
	private WebElement txt_password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement btn_login;
	
	public LoginPageFactory(WebDriver driver)
	{
		this.driver = driver;
		//In Ajax applications to handle loading time for element and to avoid 'No Element Exception'
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		//initialize all the WebElements & Ajax factory
		PageFactory.initElements(factory, this);
	}
	
	public void loginValidUser(String username, String password)
	{
		txt_username.sendKeys(username);
		txt_password.sendKeys(password);
		btn_login.click();
	}
	
	//@CacheLookup
	//once located stores the element in the memory and looks up from the memory if the element is re-used, It doesn't locate the element again
    //Do not use with Ajax Apps where DOM changes on user actions
    //Also avoid in case of StaleElementException
}
