package Maven1.Project1;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenersLogic.class)
public class TestCase13_ApplyCoupon extends BaseClass {
@Test(retryAnalyzer = RetryLogic.class)
    public void validateCouponCodeApplication() throws EncryptedDocumentException, IOException, InterruptedException {
        HomePage hp = new HomePage(driver);
        LoginPage lp = new LoginPage(driver);
        ProductPage pp = new ProductPage(driver, Duration.ofSeconds(15));
        CartPage cp = new CartPage(driver);
        CheckoutPage cop = new CheckoutPage(driver);

        hp.accountandlist();
        hp.signin_button();

        lp.Username();
        lp.clickContinueButton();
        lp.Password();
        lp.clickSignInButton();
        
        hp.searchaprod("shirt");
        hp.clickProduct();
        switchToNewTab();

        pp.addToCart();
        cp.gotocartcp();
        cp.proceedtocheckout();
        
        cop.applyCouponCode("DISC2025");

        
        Thread.sleep(2000);

        Assert.assertTrue(cop.isCouponApplied(), "Coupon code application failed or not applied correctly");
    }
}