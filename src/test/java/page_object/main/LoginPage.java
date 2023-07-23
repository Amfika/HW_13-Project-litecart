package page_object.main;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.PageBase;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static page_object.WebDriverContainer.getDriver;


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
       getDriver();
       title = "Rubber Ducks | My Store";
    }
    //метод
    public void attemptLogin(String email, String password){
        getDriver().findElement(emailInput).sendKeys(email);
        getDriver().findElement(passwordInput).sendKeys(password);
        getDriver().findElement(rememberMe).click();
        getDriver().findElement(loginButton).click();
    }
    public void logWithoutRememberMe(String email, String password){
        getDriver().findElement(emailInput).sendKeys(email);
        getDriver().findElement(passwordInput).sendKeys(password);
        getDriver().findElement(loginButton).click();
    }
    public void rememberPassword(String email){
        getDriver().findElement(emailInput).sendKeys(email);
        getDriver().findElement(lostPasswordButton).click();
    }
    //метод, который отлавливает errorMessage
    public String getErrorMessage(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.of(5, ChronoUnit.SECONDS));
        String invalMess = wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage)).getText();
        return invalMess;
    }
    public String getValidLoginMess(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.of(5,ChronoUnit.SECONDS));
        String valMess = wait.until(ExpectedConditions.presenceOfElementLocated(validMessage)).getText();
        return valMess;
    }
    public String getLogoutText(){
        String logoutElem = getDriver().findElement(logout).getText();
        return logoutElem;
    }
    public String rememberPasswordText(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.of(5,ChronoUnit.SECONDS));
        String rememberMess = wait.until(ExpectedConditions.presenceOfElementLocated(validMessageForRememberPass)).getText();
        return rememberMess;
    }
}
