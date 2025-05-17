package Maven1.Project1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersLogic.class)
public class TestCase2_Login extends BaseClass {
	@Test(retryAnalyzer = RetryLogic.class)
	public void login() throws EncryptedDocumentException, IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);

		hp.accountandlist();
		hp.signin_button();

		lp.Username();
		lp.clickContinueButton();
		lp.Password();
		lp.clickSignInButton();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(),
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}

}
