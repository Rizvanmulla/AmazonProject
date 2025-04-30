package Maven1.Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;
	@FindBy(name = "email")
	WebElement username2;

	@FindBy(id = "continue")
	WebElement cont2;

	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement submit_button;

	@FindBy(id = "ap_phone_number")
	WebElement Mobileno;

	@FindBy(id = "ap_customer_name")
	WebElement custname;
	
	@FindBy(id = "ap_password")
	WebElement newpassword;
	
	@FindBy(id = "continue")
	WebElement Cont_button3;
	
	public void un2() {
		username2.sendKeys("solapurdpm@gmail.com");
	}

	public void cont_button2() {
		cont2.click();
	}

	public void submit_button() {
		submit_button.click();
	}
	public void Mobileno() {
		Mobileno.sendKeys("9518326623");
	}
	public void custname() {
		custname.sendKeys("Solapur DPM");
	}
	public void newpassword() {
		newpassword.sendKeys("Pass@123");
	}
	public void Cont_button3() {
		Cont_button3.click();
	}
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
