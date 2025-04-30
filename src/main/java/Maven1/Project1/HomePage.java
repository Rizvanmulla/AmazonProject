package Maven1.Project1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "//span[@class='nav-line-2 ']")
	WebElement accountandlist_hoverover;

	@FindBy(xpath = "//span[.='Sign in']")
	WebElement signinbutton;

	@FindBy(xpath = "//a[@class='nav-a']")
	WebElement newuser;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchtf;

	@FindBy(css = "span.a-button.a-button-span11.a-button-base.a-button-small > span.a-button-inner > a.a-button-text")
	WebElement hpgotocart_button;

	@FindBy(xpath = "(//i[@class='a-icon a-icon-checkbox'])[3]")
	WebElement chbxgetin2days;

	@FindBy(xpath = "(//i[@class='a-icon a-icon-checkbox'])[4]")
	WebElement chbxbrndapple;

	@FindBy(linkText = "GPS")
	WebElement chbxbgps;

	@FindBy(linkText = "OLED")
	WebElement chbxoled;

	@FindBy(id = "p_36/range-slider_slider-item_lower-bound-slider")
	WebElement minSlider;

	@FindBy(linkText = "Fitness")
	WebElement chbxfitness;

	@FindBy(css = "span.a-dropdown-prompt")
	WebElement sortDropdownPrompt;

	@FindBy(xpath = "(//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal'])[4]")
	WebElement clickprod;

	@FindBy(xpath = "//span[.='Returns']")
	WebElement orders;

	// Constructor
	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void accountandlist() {
		Actions actions = new Actions(driver);
		actions.moveToElement(accountandlist_hoverover).perform();
	}

	public void signin_button() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(signinbutton))
				.click();
	}

	public void newuser() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(newuser))
				.click();
	}

	public void searchaprod(String productName) {
		// searchtf.clear();
		searchtf.sendKeys(productName + Keys.ENTER);
	}

	public void clickProduct() {
		wait.until(ExpectedConditions.elementToBeClickable(clickprod));
		clickprod.click();
	}

	public void checkbox2days() {
		wait.until(ExpectedConditions.elementToBeClickable(chbxgetin2days));
		chbxgetin2days.click();
	}

	public void checkboxApple() {
		wait.until(ExpectedConditions.elementToBeClickable(chbxbrndapple));
		chbxbrndapple.click();
	}

	public void checkboxGPS() {
		wait.until(ExpectedConditions.elementToBeClickable(chbxbgps));
		chbxbgps.click();
	}

	public void checkboxOLED() {
		wait.until(ExpectedConditions.elementToBeClickable(chbxoled));
		chbxoled.click();
	}

	public void gotocarthp() {
		wait.until(ExpectedConditions.elementToBeClickable(hpgotocart_button));
		hpgotocart_button.click();
	}

	public void selectSortOption(String sortOption) {
		sortDropdownPrompt.click();
		By options = By.partialLinkText(sortOption);
		wait.until(ExpectedConditions.elementToBeClickable(options)).click();
	}

	public String getCurrentSortOption() {
		WebElement selectedOption = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.a-dropdown-prompt")));
		return selectedOption.getText();
	}

	public void returnsorders() {
		orders.click();
	}

}
