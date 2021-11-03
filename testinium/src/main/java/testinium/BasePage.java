package testinium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver =null;
	WebDriverWait wait =null;
	
	By registerLogin =By.xpath("//*[@class='header-section']/div[1]/a");
	By login = By.xpath("//*[@class='header-section']/div[1]/a");
	By search = By.xpath("//*[@id=\"search_input\"]");
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public LoginPage getLoginPage() {
		hoverElement(registerLogin);
		click(login);
		return new LoginPage(driver);
	}
	public WebElement findElement(By by) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		return driver.findElement(by);
	}
	
	public void sendKeys(By by, String text) {
		findElement(by).sendKeys(text);
	}
	
	public void click(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));
		findElement(by).click();
	}
	
	public void hoverElement(By by) {
		Actions actions = new Actions(driver);
		actions.moveToElement(findElement(by)).build().perform();
	}
	
	public String getText(By by) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		return findElement(by).getText();
	}
	
	public void scrollPage(String nav) {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,"+nav + ")");
	}
	
	public void scrollEnd() {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void scrollVisibleElements(By element) {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public ResultSearch search(String word)  {
		
		driver.findElement(search).sendKeys(word + Keys.ENTER);
		return new ResultSearch(driver);
	}
}
