package Maven1.Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor for initialization
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Reused wait in constructor
		PageFactory.initElements(driver, this); // Initialize WebElements
	}

	// Locate the elements using @FindBy annotations
	@FindBy(xpath = "//a[@aria-label='Change delivery address']")
	WebElement addressSelection;

	@FindBy(xpath = "(//i[@class='a-icon a-icon-radio'])[1]")
	WebElement address1;

	@FindBy(xpath = "(//i[@class='a-icon a-icon-radio'])[2]")
	WebElement address2;

	@FindBy(xpath = "(//input[@class='a-button-input'])[2]")
	WebElement delivertothisaddress;

	@FindBy(xpath = "(//input[@id])[2]")
	WebElement radiocard;

	@FindBy(xpath = "(//input[@id])[3]")
	WebElement radionetbankin;

	@FindBy(xpath = "(//input[@id])[4]")
	WebElement radioupi;

	@FindBy(xpath = "(//input[@id])[8]")
	WebElement radioemi;

	@FindBy(xpath = "(//input[@id])[9]")
	WebElement radiocod;

	@FindBy(xpath = "//input[@placeholder='Enter Code']")
	WebElement couponCodeInput;

	@FindBy(xpath = "//input[@value='Apply']")
	WebElement applyCouponButton;

	@FindBy(id = "pmts-claim-code-error-messages")
	WebElement couponAppliedMessage;

	@FindBy(xpath = "(//input[@class='a-button-input'])[4]")
	WebElement usethispaymentbutton;

	@FindBy(xpath = "//a[contains(text(), 'Review Order')]")
	WebElement orderReview;

	@FindBy(id = "submitOrderButtonId")
	WebElement placeOrderButton;

	@FindBy(xpath = "//span[text()='Order Total:']")
	WebElement arrivingMessage;

	// Shipping Address Methods
	public void selectShippingAddress() {
		wait.until(ExpectedConditions.elementToBeClickable(addressSelection));
		addressSelection.click();
	}

	public void selectAddress(int addressIndex) {
		WebElement selectedAddress = (addressIndex == 1) ? address1 : address2;
		wait.until(ExpectedConditions.elementToBeClickable(selectedAddress));
		selectedAddress.click();
	}

	public void deliverToThisAddress() {
		wait.until(ExpectedConditions.elementToBeClickable(delivertothisaddress));
		delivertothisaddress.click();
	}

	// Payment Method Methods
	public void selectPaymentMethod(String paymentMethod) {
		WebElement paymentOption = null;

		switch (paymentMethod.toLowerCase()) {
		case "card":
			paymentOption = radiocard;
			break;
		case "netbanking":
			paymentOption = radionetbankin;
			break;
		case "upi":
			paymentOption = radioupi;
			break;
		case "emi":
			paymentOption = radioemi;
			break;
		case "cod":
			paymentOption = radiocod;
			break;
		default:
			throw new IllegalArgumentException("Invalid payment method: " + paymentMethod);
		}

		wait.until(ExpectedConditions.elementToBeClickable(paymentOption));
		paymentOption.click();
	}

	// Use this payment method button
	public void clickUseThisPaymentMethod() {
		wait.until(ExpectedConditions.elementToBeClickable(usethispaymentbutton));
		usethispaymentbutton.click();
	}

	// Review Order
	public void reviewOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(orderReview));
		orderReview.click();
	}

	// Coupon Code Methods
	public void applyCouponCode(String couponCode) {
		couponCodeInput.clear();
		couponCodeInput.sendKeys(couponCode);
		applyCouponButton.click();
	}

	public boolean isCouponApplied() {
		wait.until(ExpectedConditions.visibilityOf(couponAppliedMessage));
		return couponAppliedMessage.isDisplayed();
	}

	// Order Success Methods
	public boolean isOrderSuccess() {
		wait.until(ExpectedConditions.visibilityOf(arrivingMessage));
		String text = arrivingMessage.getText();
		return text.contains("Order Total:");
	}

	public boolean isPaymentOptionSelected(WebElement element) {
		return element.isSelected(); // This works if it's a radio or checkbox input
	}

	// Place Order (Optional: Uncomment to enable place order functionality)
	/*
	 * public void placeOrder() {
	 * wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
	 * placeOrderButton.click(); }
	 */
}
