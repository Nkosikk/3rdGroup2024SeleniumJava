package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static Utils.generateTestData.*;

public class CheckoutPage {

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Your Information')]")
    WebElement checkoutPageTitle;

    @FindBy(xpath = "//input[contains(@id,'first-name')]")
    WebElement shippingName;

    @FindBy(xpath = "//input[contains(@id,'last-name')]")
    WebElement shippingSurname;

    @FindBy(xpath = "//input[contains(@id,'postal-code')]")
    WebElement shippingAddress;

    @FindBy(xpath = "//input[contains(@id,'continue')]")
    WebElement shippingContinueButton;

    public void verifyCheckoutPageTitle(){
        String checkoutTitle = checkoutPageTitle.getText();
        Assert.assertEquals(checkoutTitle,"Checkout: Your Information");
    }
    public void enterShippingName(){
        shippingName.sendKeys(firstName);
    }
    public void enterShippingSurname(){
        shippingSurname.sendKeys(Surname);
    }
    public void enterShippingAddress(){
        shippingAddress.sendKeys(zipcode);
    }
    public void clickShippingContinueButton(){
        shippingContinueButton.click();
    }

}
