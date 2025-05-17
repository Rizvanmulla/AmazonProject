package Maven1.Project1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersLogic.class)
public class TestCase8_Sorting extends BaseClass {

	@Test(retryAnalyzer = RetryLogic.class)
	public void sortProductsByRelevancePriceRating() throws InterruptedException, EncryptedDocumentException, IOException {

		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);

		hp.accountandlist();
		hp.signin_button();
		lp.Username();
		lp.clickContinueButton();
		lp.Password();
		lp.clickSignInButton();

		hp.searchaprod("Laptop");

		hp.selectSortOption("Price");
		Thread.sleep(3000);
		String current = hp.getCurrentSortOption();
		Assert.assertTrue(current.toLowerCase().contains("price"),
				"Expected sort label to contain 'Price' but was: " + current);

		hp.selectSortOption("Customer Review");
		Thread.sleep(3000);
		current = hp.getCurrentSortOption();
		Assert.assertTrue(current.toLowerCase().contains("customer review"),
				"Expected sort label to contain 'Customer Review' but was: " + current);

		hp.selectSortOption("Newest");
		Thread.sleep(3000);
		current = hp.getCurrentSortOption();
		Assert.assertTrue(current.toLowerCase().contains("newest"),
				"Expected sort label to contain 'Newest' but was: " + current);

		hp.selectSortOption("Best");
		Thread.sleep(3000);
		current = hp.getCurrentSortOption();
		Assert.assertTrue(current.toLowerCase().contains("best"),
				"Expected sort label to contain 'Best' but was: " + current);
	}
}