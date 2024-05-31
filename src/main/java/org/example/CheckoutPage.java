package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends BasePage{
    private SelenideElement firstNameField = $(By.xpath("//div[@class='checkout_info']//input[@id='first-name']"));
    private SelenideElement lastNameField = $(By.xpath("//div[@class='checkout_info']//input[@id='last-name']"));
    private SelenideElement zipCodeField = $(By.xpath("//div[@class='checkout_info']//input[@id='postal-code']"));
    private SelenideElement continueButton = $(By.xpath("//div[@class='checkout_buttons']//input[@id='continue']"));

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public void putValueFirstNameField(String firstName){
        firstNameField.shouldBe(visible).setValue(firstName);
    }

    public void putValueLastNameField(String lastName){
        lastNameField.shouldBe(visible).setValue(lastName);
    }

    public void putValueZipCodeField(String firstName){
        zipCodeField.shouldBe(visible).setValue(firstName);
    }

    public void continueButtonClick(){
        continueButton.shouldBe(visible).click();
    }
}