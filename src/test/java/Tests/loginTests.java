package Tests;

import Pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class loginTests extends Base {


    public void enterUsernameTests() {
        loginPage.enterUsername(readData.username);
    }

    @Test(dependsOnMethods = "enterUsernameTests")
    public void enterPasswordTests() {
        loginPage.enterPassword(readData.password);
    }

    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests() {
        takesScreenshots.takesSnapShot(driver,"Login Page");
        loginPage.clickLogin();
    }

    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void verifyProductIsDisplayed() {
        homePage.verifyProductTitleIsDisplayed();
        takesScreenshots.takesSnapShot(driver,"Home Page");
    }
    @Test(dependsOnMethods = "verifyProductIsDisplayed")
    public void clickAddToCartButtonTests() {
        homePage.clickButtonAddToCart();
        takesScreenshots.takesSnapShot(driver, "Add To Cart");
    }
    @Test(dependsOnMethods = "clickAddToCartButtonTests")
    public void verifyCartIsNotEmpty() {
        homePage.verifyItemWasAddedToTheCart();

    }

    //ToDo read data from faker library

//    @AfterTest
//    public void closeBrowser() {
//        driver.quit();
//    }
}
