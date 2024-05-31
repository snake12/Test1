package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasePage {
    private WebDriver driver;
    public BasePage(){
        Configuration.browser = "Chrome";
        open("https://www.saucedemo.com/");
        driver = getWebDriver();
        driver.manage().window().maximize();
    }

    public BasePage(String pageUrl){
        Configuration.browser = "Chrome";
        open(pageUrl);
        driver = getWebDriver();
        driver.manage().window().maximize();
    }

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void clickElement(SelenideElement element){
        element.click();
    }

    public void setText(SelenideElement element,String text){
        element.sendKeys(text);
    }

    public void sendKeyboardKey(SelenideElement element){
        element.sendKeys();
    }

    public String getText(SelenideElement element){
        return element.getText();
    }

    public void hoverElement(SelenideElement element){
        element.hover();
    }
}