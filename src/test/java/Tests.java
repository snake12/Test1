import org.example.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.*;

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
    public void loginSuccess() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(LoginUser.STANDARD_USER.getLogin(), password);
        MainPage mainPage = new MainPage(loginPage.getDriver());
        assertTrue(mainPage.isShoppingCartVisible());
    }

    @Test
    public void loginWithWrongPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(LoginUser.STANDARD_USER.getLogin(), "password");
        assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }

    @Test
    public void mainPageTestElements() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(LoginUser.STANDARD_USER.getLogin(), password);
        MainPage mainPage = new MainPage(loginPage.getDriver());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainPage.header.isDisplayed());
        softAssert.assertTrue(mainPage.footer.isDisplayed());
        softAssert.assertTrue(mainPage.getInventoryItemByName("Sauce Labs Backpack").isDisplayed());
        softAssert.assertTrue(mainPage.getInventoryItemByName("Sauce Labs Bike Light").isDisplayed());
        softAssert.assertTrue(mainPage.getInventoryItemByName("Sauce Labs Bolt T-Shirt").isDisplayed());
        softAssert.assertTrue(mainPage.getInventoryItemByName("Sauce Labs Fleece Jacket").isDisplayed());
        softAssert.assertTrue(mainPage.getInventoryItemByName("Sauce Labs Onesie").isDisplayed());
        softAssert.assertTrue(mainPage.getInventoryItemByName("Test.allTheThings() T-Shirt (Red)").isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void checkoutItemTest() {
        String itemName = "Sauce Labs Backpack";

        LoginPage loginPage = new LoginPage();
        loginPage.login(LoginUser.STANDARD_USER.getLogin(), password);
        MainPage mainPage = new MainPage(loginPage.getDriver());
        mainPage.clickAddToCartButtonByName(itemName);
        mainPage.clickOnShoppingCart();
        CartPage cartPage = new CartPage(loginPage.getDriver());
        assertTrue(cartPage.getCartItemByName(itemName).shouldBe(visible).isDisplayed());
        cartPage.checkoutButton.click();
        CheckoutPage checkoutPage = new CheckoutPage(loginPage.getDriver());
        checkoutPage.putValueFirstNameField("Name");
        checkoutPage.putValueLastNameField("Surname");
        checkoutPage.putValueZipCodeField("22222");
        checkoutPage.continueButtonClick();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(loginPage.getDriver());
        assertEquals(checkoutOverviewPage.getCartItemsQuantity(), "1");
        assertEquals(checkoutOverviewPage.getItemName(), itemName);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(checkoutOverviewPage.getPaymentInfoFieldText(),"Payment Information:");
        softAssert.assertEquals(checkoutOverviewPage.getShippingInfoFieldText(),"Shipping Information:");
        softAssert.assertEquals(checkoutOverviewPage.getPriceTotalFieldText(),"Price Total");
        softAssert.assertAll();

        checkoutOverviewPage.clickFinishButton();

        assertEquals(mainPage.getHeaderSecondaryContainerTitle(), "Checkout: Complete!");
        assertEquals(checkoutOverviewPage.getChecoutCompleteHeaderText(), "Thank you for your order!");


    }
}
