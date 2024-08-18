package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Products')]")
    WebElement productTitle_xpath;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")
    WebElement backpackItem;
    @FindBy(xpath = "(//div[contains(@class,'inventory_item_name ')])[1]")WebElement backpackItemInfo;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-bike-light')]")
    WebElement bikeLightItem;

    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    WebElement cartIcon;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductTitleIsDisplayed() {

        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(productTitle_xpath));
        String productTitle = productTitle_xpath.getText();
        Assert.assertEquals(productTitle, "Products");
    }
    public void verifyBackpackItemIsAddedToCart(){
        backpackItem.click();
    }
    public void getBackpackItemInformation(){
        String backpackInformation = backpackItemInfo.getText();
        Assert.assertEquals(backpackInformation,"Sauce Labs Backpack");
    }
    public void verifyBikeLightItemIsAddedToCart(){
        bikeLightItem.click();
    }
    public void verifyNumberOfItemsInCart(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(cartIcon));
        String numberOfItems = cartIcon.getText();
        Assert.assertEquals(numberOfItems,"2");
    }

    public  void clickCartIcon(){
        cartIcon.click();
    }
}
