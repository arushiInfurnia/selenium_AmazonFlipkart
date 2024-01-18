package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class Test1 extends BaseClass{
	
	@Test
	public void finaltest()
	{
		AmazonIphonePriceTest aipt = new AmazonIphonePriceTest();
		
		FlipkartTest ft = new FlipkartTest();
		
		Assert.assertEquals(aipt.azon, ft.flp);
		
		log.info("Completed");
	}
	

}
