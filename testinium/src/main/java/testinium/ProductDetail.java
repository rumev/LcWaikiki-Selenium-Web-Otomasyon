package testinium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetail extends BasePage {
	 private By lowProductPrice  = By.xpath("//*[@id=\"rightInfoBar\"]/div[1]/div/div[2]/div/div/div/span[2]");

	    private By addToBasket = By.xpath("//*[@id=\"pd_add_to_cart\"]");
	    private By goToBasket = By.xpath("/html/body/div[5]/div[2]/div[1]/div[4]/div/div[4]/a");
	    private By size = By.xpath("//*[@id=\"option-size\"]/a[1]");
	public ProductDetail(WebDriver driver) {
		super(driver);
		
	}

	 public String productPrice(){
	       driver.findElement(lowProductPrice).getText();

	        return getText(lowProductPrice);
	    }
	    public void ClickSize(){
	        click(size);
	    }
	    public void addToBasket(){
	        click(addToBasket);
	    }
	    public BasketPage goToBasket(){
	        click(goToBasket);
	        return new BasketPage(driver);
	    }
}
