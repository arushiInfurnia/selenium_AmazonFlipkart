package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartIphonePage extends BasePage{

	public FlipkartIphonePage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="(//div[@class='_30jeq3 _1_WHN1'])[1]")
	WebElement price;
	
	public String capturePriceFlipkart()
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
