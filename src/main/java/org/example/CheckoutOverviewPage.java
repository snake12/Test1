package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage extends BasePage {
    private SelenideElement itemsQuantity = $(By.xpath("//div[@class='cart_item']//div[@class='cart_quantity']"));
    private SelenideElement itemName = $(By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name']"));
    private SelenideElement paymentInfoField = $(By.xpath("//div[@class='summary_info_label'][@data-test='payment-info-label']"));
    private SelenideElement shippingInfoField = $(By.xpath("//div[@class='summary_info_label'][@data-test='shipping-info-label']"));
    private SelenideElement priceTotalField = $(By.xpath("//div[@class='summary_info_label'][@data-test='total-info-label']"));
    private SelenideElement finishButton = $(By.xpath("//button[@id='finish'][text()='Finish']"));
    private SelenideElement checkoutCompleteHeader = $(By.xpath("//div[@id='checkout_complete_container']/h2[@class='complete-header']"));
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getCartItemsQuantity() {
        return itemsQuantity.getText();
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getPaymentInfoFieldText() {
        return paymentInfoField.getText();
    }

    public String getShippingInfoFieldText() {
        return shippingInfoField.getText();
    }

    public String getPriceTotalFieldText() {
        return priceTotalField.getText();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public String getChecoutCompleteHeaderText() {
        return checkoutCompleteHeader.getText();
    }
}