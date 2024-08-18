package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage {

    @FindBy(xpath = "(//div[contains(@class,'inventory_item_name')])[1]")
    WebElement cartItem;

    @FindBy(xpath = "//button[contains(@id,'checkout')]")
    WebElement checkoutButton;

    public void verifyBackpackItemIsStillInCart(){
        String ItemInfo = cartItem.getText();
        Assert.assertEquals(ItemInfo,"Sauce Labs Backpack");
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

}
