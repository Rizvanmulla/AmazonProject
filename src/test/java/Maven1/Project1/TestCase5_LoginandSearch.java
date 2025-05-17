package Maven1.Project1;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenersLogic.class)
public class TestCase5_LoginandSearch extends BaseClass {
	@Test(retryAnalyzer=RetryLogic.class)
	public void loginandsearch() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);

		hp.accountandlist();
		hp.signin_button();

		lp.Username();
		lp.clickContinueButton();
		lp.Password();
		lp.clickSignInButton();

		hp.searchaprod("Bag");
		List<WebElement> e1=driver.findElements(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']"));
		int count=e1.size();
		System.out.println(count);
		Assert.assertEquals(count>5, true);
	}

}
