package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public SelenideElement checkoutButton = $(By.xpath("//button[contains(@class,'btn_action btn_medium checkout_button')][text()='Checkout']"));


    public SelenideElement getCartItemByName(String inventoryItemName){
        SelenideElement inventoryItem = $(By.xpath("//div[@class='cart_item_label']//div[@class='inventory_item_name'][text()='"+inventoryItemName+"']"));
        return inventoryItem;
    }
}