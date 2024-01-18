package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends BasePage{

	public AmazonHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	
	//Elements
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchbox;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement searchbtn;
	
	
	//Actions
	public void clickSearch(String url)
	{
		searchbox.sendKeys(url);
	}

	public void clickSearchBtn()
	{
		searchbtn.click();
	}
	
	
}
