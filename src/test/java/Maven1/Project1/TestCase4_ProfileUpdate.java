package Maven1.Project1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenersLogic.class)
public class TestCase4_ProfileUpdate extends BaseClass{
	@Test(retryAnalyzer=RetryLogic.class)
	public void profileupdate() throws InterruptedException, EncryptedDocumentException, IOException {

		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);

		hp.accountandlist();
		hp.signin_button();

		lp.Username();
		lp.clickContinueButton();
		lp.Password();
		lp.clickSignInButton();
		Thread.sleep(2000);
		hp.accountandlist();
		lp.clickManageProfile();
		lp.clickViewProfile();
		lp.clickHeightAndWeight();
		lp.clickEditHeightWeight();
		lp.updateWeight("95");
		lp.clickSaveHeightWeight();
		
		WebElement e1=driver.findElement(By.xpath("(//dd[@class='attribute-value add-padding'])[2]"));
		Assert.assertEquals(e1.getText(), "95 kg");
	}
}
