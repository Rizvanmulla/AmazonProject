package Maven1.Project1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersLogic.class)
public class TestCase1_Registration extends BaseClass {
	@Test(retryAnalyzer = RetryLogic.class)
	public void register() {
		HomePage hp = new HomePage(driver);
		hp.accountandlist();
		hp.newuser();

		RegistrationPage rp = new RegistrationPage(driver);
		rp.un2();
		rp.cont_button2();
		rp.submit_button();
		rp.Mobileno();
		rp.custname();
		rp.newpassword();
		rp.Cont_button3();

		Assert.assertEquals(driver.getTitle(), "Authentication required");
	}
}