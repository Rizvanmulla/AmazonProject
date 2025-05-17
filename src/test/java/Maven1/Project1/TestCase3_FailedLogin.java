package Maven1.Project1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersLogic.class)
public class TestCase3_FailedLogin extends BaseClass {

	@Test(retryAnalyzer = RetryLogic.class)
	public void failedLogin() throws EncryptedDocumentException, IOException {

		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);

		hp.accountandlist();
		hp.signin_button();

		lp.Username();
		lp.clickContinueButton();
		lp.InvalidPassword();
		lp.clickSignInButton();

		String errorMessage = lp.getErrorMessage();
		Assert.assertTrue(errorMessage.contains("Your password is incorrect"),
				"Login was successful with incorrect credentials");

	}
}
