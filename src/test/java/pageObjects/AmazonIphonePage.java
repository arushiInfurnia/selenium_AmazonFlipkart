package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonIphonePage extends BasePage {

	public AmazonIphonePage(WebDriver driver) {
		super(driver);
		
	}

	/*
	 * @FindBy(xpath="//span[normalize-space()='iPhone 14 Plus (256 GB) - Yellow']")
	 * WebElement Iphonelnk;
	 */
	
	@FindBy(xpath="(//span[@class='a-price-whole'])[1]")
	WebElement price;
	
	/*
	 * public void clickIphoneAmazon() { Iphonelnk.click(); }
	 */
	
	public String capturePriceAmazon()
	{
		try
		{
			return (price.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
	}
	}
}
