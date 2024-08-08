package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    //add elements

    @FindBy(xpath = "//input[contains(@id,'user-name')]")
    WebElement username_id;

    @FindBy(xpath = "//input[contains(@id,'password')]")
    WebElement password_id;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement login_id;

    @FindBy(xpath = "//div[@class='error-message-container error'][contains(.,'Epic sadface: Username is required')]")
    WebElement loginError_xpath;

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //reading from excel
    public void enterUsername(String username) {
        username_id.sendKeys(username);
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(username_id));
    }

    public void enterPassword(String password) {
        password_id.sendKeys(password);

    }

    public void clickLogin() {
        login_id.click();
    }

    public void verifyErrorMessageInLogin() {

        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(loginError_xpath));
        loginError_xpath.isDisplayed();
    }

}

