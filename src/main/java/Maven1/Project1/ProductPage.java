package Maven1.Project1;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locating elements using @FindBy annotations
    @FindBy(id = "corePriceDisplay_desktop_feature_div")
    WebElement priceSection;

    @FindBy(id = "acrCustomerReviewText")
    WebElement reviews;

    @FindBy(id = "productTitle")
    WebElement productTitle;

    @FindBy(id = "feature-bullets")
    WebElement productDescription;

    @FindBy(xpath = "//input[@formaction]")
    WebElement addToCartButton;

    // Constructor for initialization with an optional timeout for WebDriverWait
    public ProductPage(WebDriver driver, Duration waitDuration) {
        this.driver = driver;
        // Default to 15 seconds if no waitDuration is provided
        this.wait = new WebDriverWait(driver, waitDuration != null ? waitDuration : Duration.ofSeconds(15));
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

    // Method to add the product to the cart
    public void addToCart() {
        try {
            wait.until(ExpectedConditions.visibilityOf(addToCartButton)); // Wait until the button is visible
            addToCartButton.click(); // Click the add to cart button
        } catch (TimeoutException e) {
            System.err.println("Add to Cart button not found or not clickable.");
        }
    }

    // Method to get the product price
    public String getProductPrice() {
        try {
            wait.until(ExpectedConditions.visibilityOf(priceSection)); // Wait for the price section to be visible
            return priceSection.getText().trim(); // Return the product price text
        } catch (TimeoutException e) {
            System.err.println("Price section not found.");
            return ""; // Return empty string if the price is not found
        }
    }

    // Method to get the product title
    public String getProductTitle() {
        try {
            wait.until(ExpectedConditions.visibilityOf(productTitle)); // Wait for the product title to be visible
            return productTitle.getText().trim(); // Return the product title text
        } catch (TimeoutException e) {
            System.err.println("Product title not found.");
            return ""; // Return empty string if the title is not found
        }
    }

    // Method to get the product description
    public String getProductDescription() {
        try {
            wait.until(ExpectedConditions.visibilityOf(productDescription)); // Wait for the product description to be visible
            return productDescription.getText().trim(); // Return the product description text
        } catch (TimeoutException e) {
            System.err.println("Product description not found.");
            return ""; // Return empty string if the description is not found
        }
    }

    // Method to get the product reviews
    public String getProductReviews() {
        try {
            wait.until(ExpectedConditions.visibilityOf(reviews)); // Wait for the reviews section to be visible
            return reviews.getText().trim(); // Return the reviews text
        } catch (TimeoutException e) {
            System.err.println("Product reviews not found.");
            return ""; // Return empty string if reviews are not found
        }
    }
}
