package page_object_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private static String mail = "asanastasia@gmail.com";
    private static String invalMail = "asanastasia2@gmail.com";
    private static String password = "111";
    private static String logout = "Logout";
    private static String url = "https://litecart.stqa.ru/en/";

    private static WebDriver driver;

    @BeforeMethod
    public static void setup(){
        driver = new ChromeDriver();
        driver.get(url);
    }

    @AfterMethod
    public static void teardown(){
        driver.quit();
    }

    @Test(description = "Логирование с валидными кредами")
    public static void logWithValidCred() {
        String expMessage = "You are now logged in as sd as.";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.attemptLogin(mail, password);
        loginPage.getValidLoginMess();
        Assert.assertEquals(loginPage.getValidLoginMess(), expMessage);
    }

    @Test(description = "Логирование с невалидными кредами")
    public static void logWithInvalidCred() {
        String loginPageError = "Wrong password or the account is disabled, or does not exist";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.attemptLogin(invalMail, password);
        loginPage.getErrorMessage();
        Assert.assertEquals(loginPage.getErrorMessage(), loginPageError);
    }

    @Test(description = "Логирование без чек-бокса 'Remember Me'")
    public static void logWithoutCheckbox() {
        String logout = "Logout";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logWithoutRememberMe(mail, password);
        loginPage.getLogoutText();
        Assert.assertEquals(loginPage.getLogoutText(), logout);
    }
    @Test(description = "Тестирование формы если забыл пароль")
        public static void notice(){
        String messageRememberMePassword = "A new password has been sent to your email address.";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.rememberPassword(mail);
        loginPage.rememberPasswordText();
        Assert.assertEquals(loginPage.rememberPasswordText(), messageRememberMePassword);
    }
}
