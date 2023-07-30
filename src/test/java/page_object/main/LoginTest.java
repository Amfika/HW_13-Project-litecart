package page_object.main;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.TestBase;

import static page_object.WebDriverContainer.getDriver;
import static page_object.WebDriverContainer.quitDriver;

public class LoginTest extends TestBase {
    private static String mail = "asanastasia3@gmail.com";
    private static String invalMail = "asanastasia2@gmail.com";
    private static String password = "111";
    private static String logout = "Logout";


    @Test(description = "Логирование с валидными кредами")
    public static void logWithValidCred() {
        String expMessage = "You are now logged in as sd as.";
        LoginPage loginPage = new LoginPage();
        loginPage.attemptLogin(mail, password);
        loginPage.getValidLoginMess();
        Assert.assertEquals(loginPage.getValidLoginMess(), expMessage);
    }

    @Test(description = "Логирование с невалидными кредами")
    public static void logWithInvalidCred() {
        String loginPageError = "Wrong password or the account is disabled, or does not exist";
        LoginPage loginPage = new LoginPage();
        loginPage.attemptLogin(invalMail, password);
        loginPage.getErrorMessage();
        Assert.assertEquals(loginPage.getErrorMessage(), loginPageError);
    }

    @Test(description = "Логирование без чек-бокса 'Remember Me'")
    public static void logWithoutCheckbox() {
        String logout = "Logout";
        LoginPage loginPage = new LoginPage();
        loginPage.logWithoutRememberMe(mail, password);
        loginPage.getLogoutText();
        Assert.assertEquals(loginPage.getLogoutText(), logout);
    }
    @Test(description = "Тестирование формы если забыл пароль")
        public static void notice(){
        String messageRememberMePassword = "A new password has been sent to your email address.";
        LoginPage loginPage = new LoginPage();
        loginPage.rememberPassword(mail);
        loginPage.rememberPasswordText();
        Assert.assertEquals(loginPage.rememberPasswordText(), messageRememberMePassword);
    }
}
