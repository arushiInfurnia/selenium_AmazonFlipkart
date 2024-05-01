package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AmazonHomePage;
import pageObjects.AmazonIphonePage;
import testBase.BaseClass;

public class AmazonIphonePriceTest extends BaseClass {


	public String azon;

@Test
public void price_compare()
{
	driver.get(rb.getString("url2"));

	log.info("Started");

	try
	{

		AmazonHomePage ahp = new AmazonHomePage(driver);

		ahp.clickSearch(rb.getString("iphone"));
//        ahp.clickSearch("iphone");

		ahp.clickSearchBtn();

		log.info("Amazon Search Success");

		AmazonIphonePage aip = new AmazonIphonePage(driver);

		azon = aip.capturePriceAmazon();

		System.out.println(azon);



		log.info("Amazon Price Capture Success");

	}

	catch(Exception e)
	{
		Assert.fail();
		log.info("Failed");
	}

}




}
