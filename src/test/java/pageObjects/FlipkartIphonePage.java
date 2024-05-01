package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartIphonePage extends BasePage{

	public FlipkartIphonePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath="(//div[@class='Nx9bqj _4b5DiR'])[1]")
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
