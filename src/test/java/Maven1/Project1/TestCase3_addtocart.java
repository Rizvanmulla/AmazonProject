package Maven1.Project1;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
public class TestCase3_addtocart {
	@Test
	public void login() {
//		ChromeOptions o1 = new ChromeOptions();
//		o1.addArguments("--start-maximized");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		HomePage hp=new HomePage(driver);
		
		hp.accountandlist(driver);
		hp.signin_button();
					
		LoginPage lp=new LoginPage(driver);
		lp.un();
		lp.cont_button();
		lp.pwd();
		lp.signin();
		
		hp.searchaprod();
		
		CartPage cp=new CartPage(driver);
		cp.addtocart();
		cp.gotocart();
	}

}
