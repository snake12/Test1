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
//    @BeforeSuite
//    public void beforeSuite() {
//        System.setProperty("headless", "false"); // You can set this property elsewhere
//        String headless = System.getProperty("headless");
//
//        ChromeDriverManager.chromedriver();
//        if("true".equals(headless)) {
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless");
//            driver = new ChromeDriver(chromeOptions);
//        } else {
//            driver = new ChromeDriver();
//        }
//    }
//
//    @AfterSuite
//    public void afterSuite() {
//        if(null != driver) {
//            driver.close();
//            driver.quit();
//        }
//    }


//    @BeforeClass
//    public static void setup() {
//        //определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
//        //создание экземпляра драйвера
//        WebDriver driver = new ChromeDriver();
//        //окно разворачивается на полный экран
//        driver.manage().window().maximize();
//        //задержка на выполнение теста = 10 сек.
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        //получение ссылки на страницу входа из файла настроек
//        driver.get(ConfProperties.getProperty("loginpage")); } }

    @Test
    public void loginSuccess(){
        LoginPage loginPage = new LoginPage();
        loginPage.login(LoginUser.STANDARD_USER.getLogin(), password);
        MainPage mainPage = new MainPage(loginPage.getDriver());
        //mainPage.clickMenuButton();
        //mainPage.clickMenuButton();
       // mainPage.wait(1000L);
        assertTrue(mainPage.isShoppingCartVisible());
    }

    @Test
    public void loginWithWrongPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage.login(LoginUser.STANDARD_USER.getLogin(), "password");
        MainPage mainPage = new MainPage(loginPage.getDriver());
        //mainPage.clickMenuButton();
        //mainPage.clickMenuButton();
        // mainPage.wait(1000L);
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
