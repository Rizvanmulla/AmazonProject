package Maven1.Project1;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenersLogic.class)
public class TestCase10_UpdateRemoveCart extends BaseClass {

	@Test(retryAnalyzer = RetryLogic.class)
	public void updateAndRemoveItemsFromCart() throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		ProductPage pp = new ProductPage(driver,Duration.ofSeconds(15));
		CartPage cp = new CartPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		hp.accountandlist();
        hp.signin_button();

        lp.Username();
        lp.clickContinueButton();
        lp.Password();
        lp.clickSignInButton();
        
		hp.searchaprod("wardrobe");
		hp.clickProduct();
		js.executeScript("window.scrollBy(0, 500);");
		
		switchToNewTab();
		js.executeScript("window.scrollBy(0, 500);");
		
		pp.addToCart();
		cp.gotocartcp();
		cp.removeItem();
		
		Assert.assertTrue(cp.verifyItemRemovedMessage(), "Item was not removed successfully!");
	}
}
