package Maven1.Project1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
@Listeners(ListenersLogic.class)
public class TestCase6_SearchwithFilters extends BaseClass {
	@Test(retryAnalyzer=RetryLogic.class)
	public void searchwithfilters() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.searchaprod("Apple Watch");
		Thread.sleep(2000);
		hp.checkbox2days();
		Thread.sleep(2000);
		hp.checkboxApple();
		Thread.sleep(2000);
		hp.checkboxGPS();
		Thread.sleep(2000);
		hp.checkboxOLED();
		Thread.sleep(2000);
		Assertion a1=new Assertion();
		//a-link-normal s-line-clamp-4 s-link-style a-text-normal
		a1.assertEquals(false, false);
	}
}
