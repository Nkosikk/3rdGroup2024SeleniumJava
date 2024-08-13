package Tests;

import Pages.HomePage;
import Utils.ReadData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class loginTests extends Base {


    public void enterUsernameTests() {
        loginPage.enterUsername(ReadData.username);
    }

    @Test(dependsOnMethods = "enterUsernameTests")
    public void enterPasswordTests() {
        loginPage.enterPassword(ReadData.password);
    }

    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests() {
        takesScreenshots.takesSnapShot(driver,"Login Page");
        loginPage.clickLogin();
    }

  //  @Test(dependsOnMethods = "clickLoginButtonTests")
   // public void verifyProductIsDisplayed() {
    //    homePage.verifyProductTitleIsDisplayed();
     //   takesScreenshots.takesSnapShot(driver,"Home Page");
    //}

    //ToDo read data from faker library

  //  @AfterTest
   // public void closeBrowser() {
    //    driver.quit();
  //  }
}
