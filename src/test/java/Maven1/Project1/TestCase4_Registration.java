package Maven1.Project1;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestCase4_Registration {
	@Test
	public void register() {
//		ChromeOptions o1 = new ChromeOptions();
//		o1.addArguments("--start-maximized");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		HomePage hp = new HomePage(driver);
		hp.accountandlist(driver);
		hp.newuser();
		
		RegistrationPage rp=new RegistrationPage(driver);
		rp.un2();
		rp.cont_button2();
		rp.submit_button();
		rp.Mobileno();
		rp.custname();
		rp.newpassword();
		rp.Cont_button3();
	}
}
