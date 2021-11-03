package testinium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

	By userName = By.xpath("//*[@id=\"LoginEmail\"]");
    By password = By.xpath("//*[@id=\"Password\"]");
    By login = By.xpath("//*[@id=\"loginLink\"]");
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public HomePage login(User user) {
		sendKeys(userName,user.getEmail());
		sendKeys(password,user.getPassword());
		click(login);
		
		HomePage home=new HomePage(driver);
		home.waitForLoad();
		return home;
		
	}

}
