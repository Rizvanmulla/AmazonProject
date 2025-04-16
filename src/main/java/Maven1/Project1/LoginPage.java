package Maven1.Project1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	ChromeDriver driver;
	@FindBy(name = "email")
	WebElement username;

	@FindBy(id = "continue")
	WebElement cont;

	@FindBy(id = "ap_password")
	WebElement pass;

	@FindBy(id = "signInSubmit")
	WebElement signin;

	@FindBy(xpath = "//*[@id=\"selectProfileModalId\"]/div/div/div[2]/button")
	WebElement manageprofile;

	@FindBy(xpath = "//a[@data-testid='profile-view-button']")
	WebElement viewprofile;

	public void un() {
		username.sendKeys("rizvanmulla@gmail.com");
	}

	public void cont_button() {
		cont.click();
	}

	public void pwd() {
		pass.sendKeys("Sindhudurg@123");
	}

	public void signin() {
		signin.click();
	}

	public void manageprofile(){
		manageprofile.click();
	}

	public void viewprofile() {
		viewprofile.click();
	}

	public LoginPage(ChromeDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
