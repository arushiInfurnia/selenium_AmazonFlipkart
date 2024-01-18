package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartHomePage extends BasePage {

	public FlipkartHomePage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//input[@placeholder='Search for Products, Brands and More' and @class='Pke_EE']")
	WebElement search;
	
	@FindBy(xpath="//button[@title='Search for Products, Brands and More']//*[name()='svg']")
	WebElement searchbtn;
	
	public void searchFlipkart(String text)
	{
		search.sendKeys(text);
	}
	
	public void clickSearchBtn()
	{
		searchbtn.click();
	}
}
