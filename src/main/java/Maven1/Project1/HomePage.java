package Maven1.Project1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	ChromeDriver driver;
	@FindBy(xpath = "//span[@class='nav-line-2 ']")
	WebElement accountandlist_hoverover;

	@FindBy(xpath = "//span[.='Sign in']")
	WebElement signinbutton;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchtf;
	
	@FindBy(xpath = "//a[@class='nav-a']")
	WebElement newuser;

	public void accountandlist(ChromeDriver driver)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(accountandlist_hoverover).perform();
	}
	public void newuser() {
		newuser.click();
	}
	public void signin_button()
	{
		signinbutton.click();
	}
	public void searchaprod()
	{
		searchtf.sendKeys("Apple Watch"+Keys.ENTER);
	}
	public HomePage(ChromeDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
}
