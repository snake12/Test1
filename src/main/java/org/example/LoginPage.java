package org.example;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
//import helpers.Driver;
import static com.codeborne.selenide.Selenide.*;
public class LoginPage extends BasePage {

    private SelenideElement loginField = $(By.xpath("//input[@class='input_error form_input'][@id='user-name']"));
    private SelenideElement passwordField = $(By.xpath("//input[@class='input_error form_input'][@id='password']"));
    private SelenideElement signInButton = $(By.xpath("//input[@class='submit-button btn_action'][@id='login-button']"));
    private SelenideElement errorMessage = $(By.xpath("//div[@class='error-message-container error']/h3[@data-test='error']"));

    public LoginPage() {
        super();
    }

    public LoginPage(String pageUrl) {
        super(pageUrl);
    }

    public void login(String email, String password) {
        loginField.setValue(email);
        passwordField.setValue(password);
        signInButton.click();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}