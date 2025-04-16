package Maven1.Project1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	ChromeDriver driver;

	@FindBy(id = "a-autoid-1-announce")
	WebElement adtocart_button;

	@FindBy(css = "span.a-button.a-button-span11.a-button-base.a-button-small > span.a-button-inner > a.a-button-text")
	WebElement gotocart_button;

	public void addtocart() {
		adtocart_button.click();
	}

	public void gotocart() {
		gotocart_button.click();
	}

	public CartPage(ChromeDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
