package Maven1.Project1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenersLogic.class)
public class TestCase14_rating extends BaseClass{
@Test(retryAnalyzer=RetryLogic.class)
public void rating() throws InterruptedException, EncryptedDocumentException, IOException
{
	HomePage hp=new HomePage(driver);
	hp.accountandlist();
	hp.signin_button();
	
	LoginPage lp=new LoginPage(driver);
	 lp.Username();
     lp.clickContinueButton();
     lp.Password();
     lp.clickSignInButton();
	
	hp.returnsorders();
	Assert.assertEquals(false, null);
	}
}
