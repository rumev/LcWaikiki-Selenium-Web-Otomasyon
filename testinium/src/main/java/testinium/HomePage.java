package testinium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	By main = By.xpath("/html/body");
	By closeCookies = By.xpath("//*[@id=\"footer__container\"]/div[2]/div/p[3]/button");
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getHP() {
		return driver.getTitle();
	}
	
	 public void waitForLoad() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(main));
	    }
	 
	 public void closeCookiesPopUp(){
	        click(closeCookies);
	    }

}
