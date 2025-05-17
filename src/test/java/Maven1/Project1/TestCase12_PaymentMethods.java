package Maven1.Project1;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersLogic.class)
public class TestCase12_PaymentMethods extends BaseClass {

    @Test(retryAnalyzer = RetryLogic.class)
    public void validatePaymentMethodSelection() throws EncryptedDocumentException, IOException, InterruptedException {
        HomePage hp = new HomePage(driver);
        LoginPage lp = new LoginPage(driver);
        ProductPage pp = new ProductPage(driver, Duration.ofSeconds(15));
        CartPage cp = new CartPage(driver);
        CheckoutPage cop = new CheckoutPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Login
        hp.accountandlist();
        hp.signin_button();
        lp.Username();
        lp.clickContinueButton();
        lp.Password();
        lp.clickSignInButton();

        // Search & add product to cart
        hp.searchaprod("shoes");
        Thread.sleep(2000);
        hp.clickProduct();
        Thread.sleep(2000);
        switchToNewTab();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 700);");
        pp.addToCart();
        Thread.sleep(2000);
        cp.gotocartcp();
        Thread.sleep(2000);
        cp.proceedtocheckout();
        Thread.sleep(2000);

        // Shipping Address
        cop.selectShippingAddress();
        cop.selectAddress(1); // Assuming address 1
        Thread.sleep(2000);
        cop.deliverToThisAddress();
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0, 600);");

        // Card
        cop.selectPaymentMethod("card");
        Assert.assertTrue(cop.isPaymentOptionSelected(cop.radiocard), "Card payment method selection failed");
        Thread.sleep(2000);

        // NetBanking
        cop.selectPaymentMethod("netbanking");
        Assert.assertTrue(cop.isPaymentOptionSelected(cop.radionetbankin), "Net Banking payment method selection failed");
        Thread.sleep(2000);

        // UPI
        cop.selectPaymentMethod("upi");
        Assert.assertTrue(cop.isPaymentOptionSelected(cop.radioupi), "UPI payment method selection failed");
        Thread.sleep(2000);

        // EMI
        cop.selectPaymentMethod("emi");
        Assert.assertTrue(cop.isPaymentOptionSelected(cop.radioemi), "EMI payment method selection failed");
        Thread.sleep(2000);

        // COD
        cop.selectPaymentMethod("cod");
        Assert.assertTrue(cop.isPaymentOptionSelected(cop.radiocod), "COD payment method selection failed");
    }
}
