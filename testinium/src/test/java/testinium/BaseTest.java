package testinium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {

	static WebDriver driver=null;
	
	@BeforeAll
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-notifications");
		options.addArguments("disable-popup-blocking");
		setWebDriver(new ChromeDriver(options));
		driver.manage().window().setSize(new Dimension(1440, 900));
		Log4j.info("Test is Starting");
		getWebDriver().navigate().to("https://www.lcwaikiki.com/tr-TR/TR");
		Log4j.info("This site is opening "+"www.lcwaikiki.com/tr-TR/TR");
	}
	
	public static WebDriver getWebDriver() {
		return driver;
	}
	
	public static void setWebDriver(WebDriver driver) {
		BaseTest.driver=driver;
	}
	
	@AfterAll
	public void tearDown() {
		Log4j.info("Test is Ending");
		getWebDriver().quit();
	}
}
