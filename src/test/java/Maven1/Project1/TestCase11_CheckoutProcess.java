package Maven1.Project1;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase11_CheckoutProcess extends BaseClass {

    @Test
    public void validateCompleteCheckoutProcess() throws EncryptedDocumentException, IOException, InterruptedException {
        HomePage hp = new HomePage(driver);
        LoginPage lp = new LoginPage(driver);
        ProductPage pp = new ProductPage(driver, Duration.ofSeconds(15));
        CartPage cp = new CartPage(driver);
        CheckoutPage cop = new CheckoutPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Step 1: Login
        hp.accountandlist();
        hp.signin_button();
        lp.Username();
        lp.clickContinueButton();
        lp.Password();
        lp.clickSignInButton();

        // Step 2: Search and open product
        hp.searchaprod("shirt");
        hp.clickProduct();
        switchToNewTab();

        // Step 3: Scroll and add to cart
        js.executeScript("window.scrollBy(0, 500);");
        pp.addToCart();

        // Step 4: Go to cart and checkout
        cp.gotocartcp();
        cp.proceedtocheckout();

        // Step 5: Shipping address selection
        cop.selectShippingAddress();
        cop.selectAddress(2); // Use address2 using existing method
        cop.deliverToThisAddress();

        // Step 6: Select COD payment method
        cop.selectPaymentMethod("cod"); // Uses existing generic method
        cop.clickUseThisPaymentMethod();

        // Step 7: Review and verify order success
        cop.reviewOrder();
        Assert.assertTrue(cop.isOrderSuccess(), "Order was not placed successfully");
    }
}
