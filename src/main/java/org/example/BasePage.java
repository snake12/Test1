package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasePage {
    private WebDriver driver;
    public BasePage(){
        Configuration.browser = "Chrome";
        open("https://www.saucedemo.com/");
        driver = getWebDriver();
        driver.manage().window().maximize();
        //Configuration.startMaximized = true;
        //Configuration.headless = true;
    }

    public BasePage(String pageUrl){
        Configuration.browser = "Chrome";
        open(pageUrl);
        driver = getWebDriver();
        driver.manage().window().maximize();
        //Configuration.startMaximized = true;
        //Configuration.headless = true;
    }

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    SelenideElement findById(String id){ return $(By.id(id)).shouldBe(visible,enabled); }
    SelenideElement findByClassName(String className){ return $(By.className(className)).shouldBe(visible,enabled); }
    SelenideElement findByCss(String css){ return $(By.cssSelector(css)).shouldBe(visible,enabled); }
    SelenideElement findByXpath(String xpath){ return $(By.xpath(xpath)).shouldBe(visible,enabled); }

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
