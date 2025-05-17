package Maven1.Project1;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenersLogic.class)
public class TestCase9_AddToCart extends BaseClass {

    @Test(retryAnalyzer = RetryLogic.class)
    public void addProductToCart() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        ProductPage pp = new ProductPage(driver, Duration.ofSeconds(15));
        CartPage cp=new CartPage(driver);
        
        hp.searchaprod("Shoes");
        hp.clickProduct();
        switchToNewTab();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");
        pp.addToCart();
        cp.gotocartcp();
        String cartCount = cp.getCartCount();
        Assert.assertTrue(Integer.parseInt(cartCount) > 0, "Product was not added to the cart");
    }
}
