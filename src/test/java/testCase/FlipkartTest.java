package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.FlipkartHomePage;
import pageObjects.FlipkartIphonePage;
import testBase.BaseClass;

public class FlipkartTest extends BaseClass {

	String flp;
	@Test
	public void price_compareFlipkart()
	{
		driver.get(rb.getString("url1"));
		
		log.info("Started");
		
		try
		{
			
			log.info("In try");
			FlipkartHomePage fhp = new FlipkartHomePage(driver);
			
			fhp.searchFlipkart(rb.getString("iphone"));
			
			fhp.clickSearchBtn();
			
			log.info("Flipkart Search Success");
			
			FlipkartIphonePage fip = new FlipkartIphonePage(driver);
			
			flp = fip.capturePriceFlipkart().replace("₹","");
			
			System.out.println(flp);
			
			log.info("Flipkart Capture Success");
			
		}
		
		catch(Exception e)
		{
			Assert.fail();
			log.info("Failed");
		}
		
	}
		
}
