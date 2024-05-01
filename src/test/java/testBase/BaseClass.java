package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	public static WebDriver driver = null;

	public ResourceBundle rb = ResourceBundle.getBundle("config");;

	public Logger log = LogManager.getLogger(this.getClass());;

    public static ExtentReports extent;
    public static ExtentTest logger;
    public static WebDriverWait wait;
    public static JavascriptExecutor executor;
    public static Actions actions;
    public static boolean runHeadless = true;


    @BeforeClass
	public void setup()
	{


		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
//
//		driver.manage().window().maximize();

		//driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//driver.get(rb.getString("url1"));

        if (runHeadless) {

            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("intl.accept_languages", "English");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("prefs", chromePrefs);
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("enable-automation");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("enable-iframe-based-signin");
            chromeOptions.addArguments("--window-size=1920x1080");
            chromeOptions.addArguments("--disable-gpu"); // Newly added
            chromeOptions.addArguments("ignore-certificate-errors"); // newly added
            chromeOptions.addArguments("ignore-ssl-errors");// newly added
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--dns-prefetch-disable");
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.addArguments("force-device-scale-factor=0.65");
            chromeOptions.addArguments("high-dpi-support=0.65");
            chromeOptions.addArguments("--whitelisted-ips"); //Newly added to handle ipv6 on docker and jenkins
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36 qa_automation_bot_VqbBUNSeD");
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            chromeOptions.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36 qa_automation_bot_VqbBUNSeD");
            chromeOptions.addArguments("x-qa-automation=VqbBUNSeD");


            driver = new ChromeDriver(chromeOptions);
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            executor = (JavascriptExecutor) driver;
            actions = new Actions(driver);
            Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
            String browserName = cap.getBrowserName();
            System.out.println(browserName);
            String os = cap.getPlatformName().toString();
            System.out.println(os);
            String v = cap.getBrowserVersion().toString();
            System.out.println(v);
            String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
            System.out.println(uAgent);


        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("x-qa-automation=VqbBUNSeD");
            options.addArguments("start-maximized");
            options.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.64 Safari/537.36 qa_automation_bot_VqbBUNSeD");
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            executor = (JavascriptExecutor) driver;
            actions = new Actions(driver);



        }

    }

	@AfterClass
	public void tearDown()
	{
		driver.quit(); // closes all tabs in browser
	}



public String captureScreen(String name) throws IOException {

		//date format to save screenshot name
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());


		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

		// saving screenshot in location and name format
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + name + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
}
