package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(@id,'react-burger-menu-btn')]")
    WebElement burgerMenu;

    @FindBy(xpath = "//a[contains(@id,'link')][@class='bm-item menu-item'][contains(.,'Logout')]")
    WebElement logout;

    public void clickBurgerMenu(){
        burgerMenu.click();
    }
    public void clickLogout(){
        logout.click();
    }
}
