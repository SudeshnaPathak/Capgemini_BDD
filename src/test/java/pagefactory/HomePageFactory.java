package pagefactory;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePageFactory {
	protected WebDriver driver;
	
	@FindBy(xpath="//a[text()='Dashboard']")
	private WebElement dashboard;
	
	@FindBy(xpath="//div[@class='user-icon']")
	private WebElement userIcon;
	
	@FindBy(xpath="//div[@class='dropdown-item logout']")
	private WebElement logout;
	
	@FindBy(xpath="//tr/td[1]")
	private List<WebElement> campaignIds;
	
	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}
	
	public boolean verifyHomePage()
	{
		List<String> ids = campaignIds
							.stream()
							.map(id -> id.getText())
							.collect(Collectors.toList());
		System.out.println(ids);
		return dashboard.isDisplayed();
	}
	
	public void logout()
	{
		userIcon.click();
		logout.click();
	}
}
