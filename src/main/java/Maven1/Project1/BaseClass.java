package Maven1.Project1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;

	@Parameters("browsername")
	@BeforeMethod
	public void launchBrowser(String browsername) {
		if (browsername.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please use Chrome, Edge, or Firefox only.");
		}
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void switchToNewTab() {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(windowHandles);
		// System.out.println(windowList);
		if (windowList.size() > 1) {
			driver.switchTo().window(windowList.get(1));
		} else {
			System.out.println("click on product didnt worked");
		}
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}

}
