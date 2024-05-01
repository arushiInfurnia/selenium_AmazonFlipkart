package testCase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class Test1 extends BaseClass{

    AmazonIphonePriceTest AT;
    FlipkartTest FT;

    @BeforeMethod(alwaysRun = true)
    public void BeforeClass() {
        AT = new AmazonIphonePriceTest();
        FT = new FlipkartTest();
    }

    @Test
    public void finaltest() {
        AT.price_compare(); // Call price_compare method from AmazonIphonePriceTest
        FT.price_compareFlipkart(); // Call price_compareFlipkart method from FlipkartTest

        String azon1 = AT.azon;
        System.out.println(azon1);

        String flp1 = FT.flp;
        System.out.println(flp1);

        Assert.assertEquals(azon1, flp1);
    }
}
