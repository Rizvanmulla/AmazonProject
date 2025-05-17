package Maven1.Project1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Listeners(ListenersLogic.class)
public class TestCase15_ReachCartWithoutLogin extends BaseClass{
	@Test(retryAnalyzer=RetryLogic.class)
public void reachcartwithoutlogin() throws InterruptedException
{
	HomePage hp=new HomePage(driver);
	hp.searchaprod("table");
	
	CartPage cp=new CartPage(driver);
	cp.addtocart();
	Thread.sleep(5000);
	cp.gotocartcp();
//	cp.proceedtocheckout();

	SoftAssert s1=new SoftAssert();
	s1.assertEquals(driver.getCurrentUrl(), "https://www.amazon.in/cart?ref_=ewc_gtc");
	s1.assertAll();
}

}
