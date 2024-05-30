package org.example;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
//import helpers.Driver;
import static com.codeborne.selenide.Selenide.*;
public class LoginPage extends BasePage {

    public SelenideElement loginField = $(By.xpath("//input[@class='input_error form_input'][@id='user-name']"));
    public SelenideElement passwordField = $(By.xpath("//input[@class='input_error form_input'][@id='password']"));
    public SelenideElement signInButton = $(By.xpath("//input[@class='submit-button btn_action'][@id='login-button']"));
    public SelenideElement termsOfUseLabel = $("label[for=\"login_agree\"]");

    public LoginPage() {
        super();
    }

    public LoginPage(String pageUrl) {
        super(pageUrl);
    }

    public void login(String email, String password) {
        loginField.setValue(email);
        passwordField.setValue(password);
        //termsOfUseLabel.click();
        signInButton.click();
        //Driver.waitForUrlContains("account/accounts");
    }



}
