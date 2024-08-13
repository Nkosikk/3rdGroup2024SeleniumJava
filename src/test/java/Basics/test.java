package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class test {


    public static void main(String[] args) {
        // Set ChromeDriver path

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Step 1: Go to https://www.kurtosys.com/
        driver.get("https://www.kurtosys.com/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Step 2: Scroll to "RESOURCES" link and click
        WebElement resourcesLink = driver.findElement(By.xpath("//li[@id='menu-item-24149']/a"));
        scrollIntoView(driver, resourcesLink);
        resourcesLink.click();

        // Step 3: From the drop down, click on “White Papers & eBooks”
        WebElement whitePapersOption = driver.findElement(By.xpath("//li[@id='menu-item-23835']/a"));
        whitePapersOption.click();

        // Step 4: Verify Title reads “White Papers”
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("White Papers"));

        // Step 5: Scroll to the "UCITS Whitepaper" link
        WebElement ucitsWhitepaper = driver.findElement(By.linkText("UCITS Whitepaper"));
        scrollIntoView(driver, ucitsWhitepaper);

        // Step 6: Click on “UCITS Whitepaper”
        ucitsWhitepaper.click();

        // Step 7: Fill in Field for “First Name”
        WebElement firstNameField = driver.findElement(By.id("fName"));
        firstNameField.sendKeys("John");

        // Step 8: Fill in Field for “Last Name”
        WebElement lastNameField = driver.findElement(By.id("lName"));
        lastNameField.sendKeys("Doe");

        // Step 9: Fill in Field for “Company”
        WebElement companyField = driver.findElement(By.id("company"));
        companyField.sendKeys("ABC Company");

        // Step 10: Fill in Field for “Industry”
        WebElement industryField = driver.findElement(By.id("industry"));
        industryField.sendKeys("IT");

        // Step 11: Please Note: DO NOT populate the "Email” field

        // Step 12: Click “Send me a copy”
        WebElement sendCopyButton = driver.findElement(By.id("email-submission"));
        sendCopyButton.click();

        // Step 13: Add screenshot of the error messages (not implemented in code, but can be done using Selenium's screenshot capabilities)

        // Step 14: Validate all error messages (if any)

        // Close the browser
        driver.quit();
    }

    // Helper method to scroll into view using JavaScript
    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


}
