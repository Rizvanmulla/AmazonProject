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

    // Locate the elements using @FindBy annotations
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

    // Constructor for initialization
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Reused wait in constructor
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

    // Navigate to cart page
    public void gotocartcp() {
        wait.until(ExpectedConditions.visibilityOf(cpgotocart)); // Wait for the element to be visible
        cpgotocart.click(); // Click to go to cart
    }

    // Update the quantity of an item in the cart
    public void updateItemQuantity(int quantity) {
        wait.until(ExpectedConditions.visibilityOf(quantityInput)); // Wait for the quantity input field to be visible
        quantityInput.clear(); // Clear the current value
        quantityInput.sendKeys(String.valueOf(quantity)); // Enter the new quantity
    }

    // Remove an item from the cart
    public void removeItem() {
        wait.until(ExpectedConditions.elementToBeClickable(removeItemButton)); // Wait for the remove button to be clickable
        removeItemButton.click(); // Click to remove the item
    }

    // Check if the cart is empty
    public boolean isCartEmpty() {
        wait.until(ExpectedConditions.visibilityOf(emptyCartMessage)); // Wait for the empty cart message
        return emptyCartMessage.isDisplayed(); // Return whether the empty cart message is displayed
    }

    // Add an item to the cart
    public void addtocart() {
        wait.until(ExpectedConditions.elementToBeClickable(adtocart_button)); // Wait for the add to cart button to be clickable
        adtocart_button.click(); // Click to add the item to the cart
    }

    // Proceed to checkout
    public void proceedtocheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedtocheckout)); // Wait for the proceed button to be clickable
        proceedtocheckout.click(); // Click to proceed to checkout
    }

    // Verify the message shown after removing an item from the cart
    public boolean verifyItemRemovedMessage() {
        wait.until(ExpectedConditions.visibilityOf(itemremoved)); // Wait for the item removed message to appear
        String message = itemremoved.getText().trim(); // Get the message text
        return message.contains("removed from Shopping Cart"); // Check if the message contains "removed"
    }

    // Get the current cart count
    public String getCartCount() {
        wait.until(ExpectedConditions.visibilityOf(cartCountElement)); // Wait for the cart count element to be visible
        return cartCountElement.getText(); // Return the cart count text
    }
}
