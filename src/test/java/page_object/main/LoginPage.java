package page_object.main;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.PageBase;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static java.time.Duration.*;
import static page_object.WebDriverContainer.getDriver;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage extends PageBase {
    //локаторы
    private By emailInput = Locators.getLocator("LoginPage.emailInput");
    private By passwordInput = Locators.getLocator("LoginPage.passwordInput");
    private By loginButton = Locators.getLocator("LoginPage.loginButton");
    private By rememberMe = Locators.getLocator("LoginPage.rememberMe");
    private By errorMessage = Locators.getLocator("LoginPage.errorMessage");
    private By validMessage = Locators.getLocator("LoginPage.validMessage");
    private By validMessageForRememberPass = Locators.getLocator("LoginPage.validMessageForRememberPass");
    private By logout = Locators.getLocator("LoginPage.logout");
    private By lostPasswordButton = Locators.getLocator("LoginPage.lostPasswordButton");


    public static void LoginPage(){
       title = "Rubber Ducks | My Store";
    }
    //метод
    public void attemptLogin(String email, String password){
        $(emailInput).sendKeys(email);
        $(passwordInput).sendKeys(password);
        $(rememberMe).click();
        $(loginButton).click();
    }
    public void logWithoutRememberMe(String email, String password){
        $(emailInput).sendKeys(email);
        $(passwordInput).sendKeys(password);
        $(loginButton).click();
    }
    public void rememberPassword(String email){
        $(emailInput).sendKeys(email);
        $(lostPasswordButton).click();
    }
    //метод, который отлавливает errorMessage
    public String getErrorMessage(){
        $(errorMessage).should(Condition.appear);
        WebDriver driver = WebDriverRunner.getWebDriver();
        return $(errorMessage).getText();
    }
    public String getValidLoginMess(){
        $(validMessage).should(Condition.appear);
        return $(validMessage).getText();
    }
    public String getLogoutText(){
        String logoutElem = $(logout).getText();
        return logoutElem;
    }
    public String rememberPasswordText(){
        $(validMessageForRememberPass).should(Condition.appear);
        return $(validMessageForRememberPass).getText();
    }
    }

