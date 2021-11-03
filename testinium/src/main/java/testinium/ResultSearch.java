package testinium;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ResultSearch extends BasePage {

	By showMore =By.xpath("//*[@id=\"divModels\"]/div[7]/div/div[4]/a");
	By body = By.xpath("/html/body");
	public ResultSearch(WebDriver driver) {
		super(driver);
		
	}

	public By randomProduct() {
        Random random = new Random();
        int rnd = random.nextInt(30) ;
        return By.xpath("/html/body/div[5]/div[3]/div[2]/div[7]/div/div[1]/div[" + rnd + "]/a");

    }
	
	public void choosePage() {
		driver.findElement(body).sendKeys(Keys.ARROW_UP);
		click(showMore);
	}
	
	 public ProductDetail goToProductDetails() throws InterruptedException{
	        

	        click(randomProduct());
	        return new ProductDetail(driver);
	    }


}
