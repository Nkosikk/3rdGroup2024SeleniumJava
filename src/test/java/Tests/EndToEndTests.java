package Tests;

import Utils.ReadData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class EndToEndTests extends Base {


    public void enterUsernameTests() {
        loginPage.enterUsername(ReadData.username);
    }

    @Test(dependsOnMethods = "enterUsernameTests")
    public void enterPasswordTests() {
        loginPage.enterPassword(ReadData.password);
    }

    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests() {
        takesScreenshots.takesSnapShot(driver, "Login Page");
        loginPage.clickLogin();
    }

    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void verifyProductTitleIsDisplayedTest() {
        homePage.verifyProductTitleIsDisplayed();
        takesScreenshots.takesSnapShot(driver,"Home Page");
    }

    @Test(dependsOnMethods = "verifyProductTitleIsDisplayedTest")
    public void verifyBackpackItemIsAddedToCart() {
        homePage.verifyBackpackItemIsAddedToCart();
    }

    @Test(dependsOnMethods = "verifyBackpackItemIsAddedToCart")
    public void getBackpackItemInformation() {
        homePage.getBackpackItemInformation();
    }

    @Test(dependsOnMethods = "getBackpackItemInformation")
    public void verifyBikeLightItemIsAddedToCart() {
        homePage.verifyBikeLightItemIsAddedToCart();
    }

    @Test(dependsOnMethods = "verifyBikeLightItemIsAddedToCart")
    public void verifyNumberOfItemsInCart() {
        homePage.verifyNumberOfItemsInCart();
    }

    @Test(dependsOnMethods = "verifyBikeLightItemIsAddedToCart")
    public  void clickCartIcon() {
        takesScreenshots.takesSnapShot(driver,"Cart Items");
        homePage.clickCartIcon();
    }


        @Test(dependsOnMethods = "verifyNumberOfItemsInCart")
        public void verifyBackpackItemIsStillInCart() {
            cartPage.verifyBackpackItemIsStillInCart();
        }

        @Test(dependsOnMethods = "verifyBackpackItemIsStillInCart")
        public void clickCheckoutButton() {
            takesScreenshots.takesSnapShot(driver,"Cart Content");
            cartPage.clickCheckoutButton();
        }
    @Test(dependsOnMethods = "clickCheckoutButton")
    public void verifyCheckoutPageTitle(){
        checkoutPage.verifyCheckoutPageTitle();
    }
    @Test(dependsOnMethods = "verifyCheckoutPageTitle")
    public void enterShippingName(){
        checkoutPage.enterShippingName();
        takesScreenshots.takesSnapShot(driver,"Shipping Page");
    }
    @Test(dependsOnMethods = "enterShippingName")
    public void enterShippingSurname(){
        checkoutPage.enterShippingSurname();
    }
    @Test(dependsOnMethods = "enterShippingSurname")
    public void enterShippingAddress(){
        checkoutPage.enterShippingAddress();
    }
    @Test(dependsOnMethods = "enterShippingAddress")
    public void clickShippingContinueButton(){
        takesScreenshots.takesSnapShot(driver,"Shipping Details");
        checkoutPage.clickShippingContinueButton();
    }

    @Test(dependsOnMethods = "clickShippingContinueButton")
    public void verifyOverviewPageTitle(){
        itemsOverviewPage.verifyOverviewPageTitle();
    }
    @Test(dependsOnMethods = "verifyOverviewPageTitle")
    public void verifySubTotalAmount(){
        itemsOverviewPage.verifySubTotalAmount();
    }
    @Test(dependsOnMethods = "verifySubTotalAmount")
    public void verifyTaxForPurchase(){
        itemsOverviewPage.verifyTaxForPurchase();
        takesScreenshots.takesSnapShot(driver,"Items Total");
    }
    @Test(dependsOnMethods = "verifyTaxForPurchase")
    public void verifyTotalAmount(){
        itemsOverviewPage.verifyTotalAmount();
        takesScreenshots.takesSnapShot(driver,"Cancel or Finish");
    }
   // @Test(dependsOnMethods = "verifyTotalAmount")
  //  public void clickFinishButton(){
   //     takesScreenshots.takesSnapShot(driver,"Items Total");
    //    itemsOverviewPage.clickFinishButton();
  //  }

 //   @Test(dependsOnMethods = "clickFinishButton")
 //   public void verifyConfirmationOrderText(){
  //      itemsOverviewPage.verifyConfirmationOrderText();
  //      takesScreenshots.takesSnapShot(driver,"Order Confirmed");
  //  }
    @Test(dependsOnMethods = "verifyTotalAmount")
    public void clickBurgerMenu(){
        logoutPage.clickBurgerMenu();
        takesScreenshots.takesSnapShot(driver,"Burger Menu");

    }
    @Test(dependsOnMethods = "clickBurgerMenu")
    public void clickLogout(){
        logoutPage.clickLogout();
        takesScreenshots.takesSnapShot(driver,"Logged Out");

    }


}
