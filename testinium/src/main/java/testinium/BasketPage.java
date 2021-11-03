package testinium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{
    private final By priceInTheBasket = By.xpath("//*[@id=\"ShoppingCartContent\"]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/span");
    private By numberOfProducts = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/a[2]");
    private By totalProduct = By.cssSelector("#ShoppingCartContent > div.row.mt-20.main-content-row > div.col-md-8 > div:nth-child(1) > div > span");
    private By deleteProduct = By.className("cart-square-link");
    private By emptyBasket = By.xpath("//*[@id=\"ShoppingCartContent\"]/div[1]/div/div/p[1]");
    private By acceptDeleteProduct = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div[3]/div/div/a[1]");


    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String priceInTheBasket(){
       return driver.findElement(priceInTheBasket).getText();
    }

    public void setNumberOfProducts(){
        click(numberOfProducts);
    }

    public String getTotalProduct(){
        return driver.findElement(totalProduct).getText();
    }

    public void deleteProduct(){

        click(deleteProduct);
        click(acceptDeleteProduct);


    }

    public String isEmpty(){
        return driver.findElement(emptyBasket).getText();
    }
}
