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

    // Locate elements on the homepage using @FindBy annotations
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

    @FindBy(xpath = "(//a[contains(@class, 'a-link-normal')]/descendant::h2)[1]")
    WebElement clickprod;

    @FindBy(xpath = "//span[.='Returns']")
    WebElement orders;

    // Constructor to initialize elements and WebDriverWait
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // WebDriverWait initialization
        PageFactory.initElements(driver, this); // Initialize the elements
    }

    // Hover over the account and list section
    public void accountandlist() {
        Actions actions = new Actions(driver);
        actions.moveToElement(accountandlist_hoverover).perform();
    }

    // Click the Sign In button
    public void signin_button() {
        wait.until(ExpectedConditions.elementToBeClickable(signinbutton)).click();
    }
    // Click the New User link
    public void newuser() {
        wait.until(ExpectedConditions.elementToBeClickable(newuser)).click();
    }

    // Search for a product
    public void searchaprod(String productName) {
        searchtf.sendKeys(productName + Keys.ENTER);
    }

    // Click on the first product
    public void clickProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(clickprod)).click();
    }

    // Select the "Get it in 2 days" checkbox
    public void checkbox2days() {
        wait.until(ExpectedConditions.elementToBeClickable(chbxgetin2days)).click();
    }

    // Select the "Apple" brand checkbox
    public void checkboxApple() {
        wait.until(ExpectedConditions.elementToBeClickable(chbxbrndapple)).click();
    }

    // Select the "GPS" checkbox
    public void checkboxGPS() {
        wait.until(ExpectedConditions.elementToBeClickable(chbxbgps)).click();
    }

    // Select the "OLED" checkbox
    public void checkboxOLED() {
        wait.until(ExpectedConditions.elementToBeClickable(chbxoled)).click();
    }

    // Click the "Go to Cart" button on the homepage
    public void gotocarthp() {
        wait.until(ExpectedConditions.elementToBeClickable(hpgotocart_button)).click();
    }

    // Select a sort option from the dropdown
    public void selectSortOption(String sortOption) {
        sortDropdownPrompt.click(); // Click the sort dropdown
        By options = By.partialLinkText(sortOption); // Locate the sort option
        wait.until(ExpectedConditions.elementToBeClickable(options)).click(); // Wait for the option to be clickable and click it
    }

    // Get the current sort option from the dropdown
    public String getCurrentSortOption() {
        WebElement selectedOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.a-dropdown-prompt")));
        return selectedOption.getText();
    }

    // Click on the 'Returns' section
    public void returnsorders() {
        orders.click(); // Click the returns orders section
    }
}
