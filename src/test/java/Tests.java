import org.example.*;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Tests {

    private String password = "secret_sauce";
    public enum LoginUser {

        VISUAL_USER("visual_user"),
        ERROR_USER("error_user"),
        STANDARD_USER("standard_user"),
        LOCKED_OUT_USER("locked_out_user"),
        PROBLEM_USER("problem_user"),
        PERFORMANCE_GLITCH_USER("performance_glitch_user");
        private final String login;

        LoginUser(String login) {
            this.login = login;
        }

        public String getLogin() {
            return login;
        }
    }

    @Test
    public void loginSuccess(){
        LoginPage loginPage = new LoginPage();
        loginPage.login(LoginUser.STANDARD_USER.getLogin(), password);
        MainPage mainPage = new MainPage(loginPage.getDriver());
        assertTrue(mainPage.isShoppingCartVisible());
    }

    @Test
    public void loginWithWrongPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage.login(LoginUser.STANDARD_USER.getLogin(), "password");
        MainPage mainPage = new MainPage(loginPage.getDriver());
        assertFalse(mainPage.isShoppingCartVisible());
    }

    @Test
    public void mainPageTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(LoginUser.STANDARD_USER.getLogin(), password);
        MainPage mainPage = new MainPage(loginPage.getDriver());
        assertTrue(mainPage.header.isDisplayed());
        assertTrue(mainPage.footer.isDisplayed());
        assertTrue(mainPage.getInventoryItemByName("Sauce Labs Backpack").isDisplayed());
        assertTrue(mainPage.getInventoryItemByName("Sauce Labs Bike Light").isDisplayed());
        assertTrue(mainPage.getInventoryItemByName("Sauce Labs Bolt T-Shirt").isDisplayed());
        assertTrue(mainPage.getInventoryItemByName("Sauce Labs Fleece Jacket").isDisplayed());
        assertTrue(mainPage.getInventoryItemByName("Sauce Labs Onesie").isDisplayed());
        assertTrue(mainPage.getInventoryItemByName("Test.allTheThings() T-Shirt (Red)").isDisplayed());
    }
}
