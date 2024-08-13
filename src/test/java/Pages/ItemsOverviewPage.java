package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class ItemsOverviewPage {
    double subTotalTrim;
    double taxTrim;
    double totalCalculated;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Overview')]")
    WebElement overviewTitle;

    @FindBy(xpath = "//div[contains(@class,'summary_subtotal_label')]")
    WebElement subTotalAmount;

    @FindBy(xpath = "//div[contains(@class,'summary_tax_label')]")
    WebElement taxForPurchase;

    @FindBy(xpath = "//div[contains(@class,'summary_total_label')]")
    WebElement totalAmount;

    @FindBy(xpath = "//button[contains(@id,'cancel')]")
    WebElement cancelOrder;

    @FindBy(xpath = "//h2[contains(@class,'complete-header')]")
    WebElement confirmationOrderText;

    @FindBy(xpath = "//button[contains(@id,'finish')]")
    WebElement finishButton;

    public void verifyOverviewPageTitle(){
        String overviewPage = overviewTitle.getText();
        assertEquals(overviewPage,"Checkout: Overview");
    }
    public void verifySubTotalAmount(){
        String subTotal = subTotalAmount.getText();
        System.out.println(subTotal);
        String subTotalString = subTotal.substring(13);
      //  String subTotalString1 = subTotal.replace("Item total: $","");
        subTotalTrim = Double.parseDouble(subTotalString);
        System.out.println(subTotalTrim);
    }
    public void verifyTaxForPurchase(){
        String tax = taxForPurchase.getText();
        System.out.println(tax);
        String subTaxString = tax.substring(6);
        //String subTaxString1 = tax.replace("Tax: $","");
        taxTrim = Double.parseDouble(subTaxString);
    }
    public void verifyConfirmationOrderText(){
        String successOrderMessage = confirmationOrderText.getText();
        assertEquals(successOrderMessage,"Thank you for your order!");
    }

    public void verifyTotalAmount(){
        double AssertedTotal;
        String theTotalAmount = totalAmount.getText();
        String trimToTalAmount = theTotalAmount.substring(8);
        System.out.println(trimToTalAmount);
        AssertedTotal = Double.parseDouble(trimToTalAmount);
        totalCalculated = subTotalTrim + taxTrim;
        //Assert.assertEquals(theTotalAmount,"Total: $"+totalCalculated);

        if (totalCalculated == AssertedTotal){

            finishButton.click();
            verifyConfirmationOrderText();
            Assert.assertTrue(true);
        }else{
            cancelOrder.click();
            Assert.fail();

        }
    }

}
