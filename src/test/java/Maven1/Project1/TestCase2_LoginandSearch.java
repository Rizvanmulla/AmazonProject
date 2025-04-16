package Maven1.Project1;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
public class TestCase2_LoginandSearch {
	@Test
	public void login() {
//		ChromeOptions o1 = new ChromeOptions();
//		o1.addArguments("--start-maximized");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		
		hp.accountandlist(driver);
		hp.signin_button();
					
		lp.un();
		lp.cont_button();
		lp.pwd();
		lp.signin();
		
		hp.searchaprod();
	}

}
