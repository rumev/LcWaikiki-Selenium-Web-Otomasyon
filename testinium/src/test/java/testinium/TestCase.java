package testinium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestCase extends BaseTest {

	@Test
	public void Testinium() throws InterruptedException {
		String title = "LC Waikiki | Ýlk Alýþveriþte Kargo Bedava! - LC Waikiki";
		String email = "rumev@outlook.com";
		String password ="Auh*XP26.e5sQh3";
		
		HomePage homePage = new HomePage(driver);
        String driverTitle = homePage.getHP();
        
        Log4j.info("Title: " + driverTitle);
        assertEquals(driverTitle, title);
        homePage.closeCookiesPopUp();
        Log4j.info("Going to Login Page");
        LoginPage loginPage = homePage.getLoginPage();
        Log4j.info("email: " + email + ", password: " + password);
        User user = new User(email, password);
        loginPage.login(user);
        
     
        
        Log4j.info("The word 'pantolon' is entered in the search box.");
        
        ResultSearch resSearch =homePage.search("pantolon");
        Thread.sleep(5000);
        resSearch.scrollEnd();
        
        Log4j.info("The page selected from the search results page opens.");
        
        resSearch.choosePage();
        resSearch.scrollEnd();
        Thread.sleep(3000);
        Log4j.info("Going to Product details page");
        ProductDetail prodDetails = resSearch.goToProductDetails();
        
        Log4j.info("Product price info is received.");
        String productPrice = prodDetails.productPrice();
        prodDetails.ClickSize();
        resSearch.scrollPage("300");
        Log4j.info("The selected product is added to the basket.");
        prodDetails.addToBasket();
        
        Log4j.info("Going to my cart page.");
        BasketPage basketPage = prodDetails.goToBasket();
        Log4j.info("The price on the product page is compared with the price of the product in the basket.");
        assertEquals(productPrice, basketPage.priceInTheBasket());
        
        Log4j.info("The number of products is increased.");
        basketPage.setNumberOfProducts();
        Thread.sleep(3000);
        assertTrue(basketPage.getTotalProduct().contains("Sepetim (2 Ürün)"));
        Log4j.info("The product is deleted from the basket.");
        basketPage.deleteProduct();
        Thread.sleep(3000);
        String basketMessage = "Sepetinizde ürün bulunmamaktadýr.";
        Log4j.info("Check if the basket is empty");
        assertEquals(basketMessage, basketPage.isEmpty());
	}
}
