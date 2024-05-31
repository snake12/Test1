package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage{
    public SelenideElement menuButton = $(By.xpath("//button[@id='react-burger-menu-btn']"));
    public SelenideElement logoutButton = $(By.xpath("//nav[@class='bm-item-list']/a[text()='Logout']"));
    public SelenideElement shoppingCart = $(By.xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement header = $(By.xpath("//div[@id='header_container']"));
    private SelenideElement headerSecondaryContainerTitle = $(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"));
    public SelenideElement footer = $(By.xpath("//footer[@class='footer']"));

    public MainPage() {
        super();
    }

    public MainPage(String pageUrl) {
        super(pageUrl);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SelenideElement getLogoutButton() {
        return logoutButton;
    }

    public void clickMenuButton(){
        menuButton.shouldBe(visible).click();
    }

    public boolean isShoppingCartVisible(){
        return shoppingCart.shouldBe(visible).isDisplayed();
    }

    public void clickOnShoppingCart(){
        shoppingCart.shouldBe(visible).click();
    }

    public SelenideElement getInventoryItemByName(String inventoryItemName){
        SelenideElement inventoryItem = $(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_name '][text()='"+inventoryItemName+"']"));
        return inventoryItem;
    }

    public void clickAddToCartButtonByName(String itemName){
        $(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_name '][text()='"+itemName+"']/../../..//div[@class='pricebar']/button[text()='Add to cart']")).shouldBe(visible).click();
    }

    public String getHeaderSecondaryContainerTitle(){
        return headerSecondaryContainerTitle.getText();
    }
}