package Maven1.Project1;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends UtilityPage {
    WebDriver driver;
    WebDriverWait wait;

    // WebElement declarations
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

    @FindBy(id = "accordion-height-and-weight-id")
    WebElement hightnweight;

    @FindBy(xpath = "(//button[@class='attribute-action'])[1]")
    WebElement edit_hw;

    @FindBy(xpath = "(//input[@class='number-input-box'])[3]")
    WebElement newweight;

    @FindBy(xpath = "(//button[text()='Save'])[2]")
    WebElement save_hw;

    @FindBy(className = "a-alert-content")
    WebElement errorMessage;

    // Constructor for initializing WebDriver, PageFactory, and wait
    public LoginPage(WebDriver driver) throws EncryptedDocumentException, IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Attempt to fetch data
        try {
            datafetch();
        } catch (Exception e) {
            System.out.println("Failed to fetch data: " + e.getMessage());
        }
    }

    // Action Methods

    public void Username() {
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(uname);
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cont));
        cont.click();
    }

    public void Password() {
        wait.until(ExpectedConditions.visibilityOf(pass));
        pass.sendKeys(pwd);
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signin));
        signin.click();
    }

    public void clickManageProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(manageprofile));
        manageprofile.click();
    }

    public void clickViewProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(viewprofile));
        viewprofile.click();
    }

    public void clickHeightAndWeight() {
        wait.until(ExpectedConditions.elementToBeClickable(hightnweight));
        hightnweight.click();
    }

    public void clickEditHeightWeight() {
        wait.until(ExpectedConditions.elementToBeClickable(edit_hw));
        edit_hw.click();
    }

    public void updateWeight(String newWeight) {
        wait.until(ExpectedConditions.visibilityOf(newweight));
        newweight.clear();
        newweight.sendKeys(newWeight);
    }

    public void clickSaveHeightWeight() {
        if (save_hw.isDisplayed() && save_hw.isEnabled()) {
            save_hw.click();
        }
    }

    public void InvalidPassword() {
        wait.until(ExpectedConditions.visibilityOf(pass));
        pass.sendKeys(invalidPwd);
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}
