package Maven1.Project1;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends UtilityPage {
	WebDriver driver;
   
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
    
    @FindBy(className="a-alert-content")
    WebElement errorMessage;

    // Constructor
    public LoginPage(WebDriver driver) throws EncryptedDocumentException, IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
      
        try {
        	  datafetch();
         
        } catch (Exception e) {
            System.out.println("Failed to fetch data: " + e.getMessage());
        }
    }

    // Action Methods
    public void un() {
    	
        username.sendKeys(uname);
    }

    public void cont_button() {
        cont.click();
    }

    public void pwd() {
        pass.sendKeys(pwd);
    }

    public void signin() {
        signin.click();
    }

    public void clickManageProfile() {
        manageprofile.click();
    }

    public void clickViewProfile() {
        viewprofile.click();
    }

    public void clickHeightAndWeight() {
        hightnweight.click();
    }

    public void clickEditHeightWeight() {
        edit_hw.click();
    }

    public void updateWeight() throws InterruptedException {
        newweight.clear();
        newweight.sendKeys("95");
        Thread.sleep(3000);
    }

    public void clickSaveHW() {
        if (save_hw.isDisplayed() && save_hw.isEnabled()) {
            save_hw.click();
        }
    }

	public void invalidPwd() {
		
		pass.sendKeys(invalidPwd);
	}

	public String getErrorMessage() {
    return errorMessage.getText();
}
}
