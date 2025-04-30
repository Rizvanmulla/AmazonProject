package Maven1.Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "a-autoid-4-announce")
	WebElement adtocart_button;

	@FindBy(xpath = "(//a[@class='a-button-text'])[1]")
	WebElement cpgotocart;

	@FindBy(name = "proceedToRetailCheckout")
	WebElement proceedtocheckout;

	@FindBy(css = "input.cart-quantity-input")
	WebElement quantityInput;

	@FindBy(xpath = "(//span[@data-action='delete'])[1]")
	WebElement removeItemButton;

	@FindBy(id = "emptyCart")
	WebElement emptyCartMessage;

	@FindBy(xpath = "//div[@class='sc-list-item-removed-msg']")
	WebElement itemremoved;

	@FindBy(xpath = "(//div[@class='a-declarative'])[2]")
	WebElement cartCountElement;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void gotocartcp() {
		wait.until(ExpectedConditions.visibilityOf(cpgotocart));
		cpgotocart.click();
	}

	public void updateItemQuantity(int quantity) {
		quantityInput.clear();
		quantityInput.sendKeys(String.valueOf(quantity));
	}

	public void removeItem() {
		removeItemButton.click();
	}

	public boolean isCartEmpty() {
		return emptyCartMessage.isDisplayed();
	}

	public void addtocart() {
		wait.until(ExpectedConditions.visibilityOf(adtocart_button));
		adtocart_button.click();
	}

	public void proceedtocheckout() {
		wait.until(ExpectedConditions.visibilityOf(proceedtocheckout));
		proceedtocheckout.click();
	}

	public boolean verifyItemRemovedMessage() {
		wait.until(ExpectedConditions.visibilityOf(itemremoved));
		String message = itemremoved.getText().trim();
		return message.contains("removed from Shopping Cart");
	}

	public String getCartCount() {
		return cartCountElement.getText();
	}

}
