package page_object_main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    //локаторы
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");
    private By rememberMe = By.name("remember_me");
    private By errorMessage = By.cssSelector("div[class='notice errors']");
    private By validMessage = By.cssSelector("div[class='notice success']");
    private By validMessageForRememberPass = By.cssSelector("div[class='notice success']");
    private By logout = By.xpath("//div[@class='content']/ul[@class='list-vertical']/li/a[@href='https://litecart.stqa.ru/en/logout']");
    private By lostPasswordButton = By.name("lost_password");
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    //метод
    public void attemptLogin(String email, String password){
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(rememberMe).click();
        driver.findElement(loginButton).click();
    }
    public void logWithoutRememberMe(String email, String password){
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    public void rememberPassword(String email){
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(lostPasswordButton).click();
    }
    //метод, который отлавливает errorMessage
    public String getErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String invalMess = wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage)).getText();
        return invalMess;
    }
    public String getValidLoginMess(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String valMess = wait.until(ExpectedConditions.presenceOfElementLocated(validMessage)).getText();
        return valMess;
    }
    public String getLogoutText(){
        String logoutElem = driver.findElement(logout).getText();
        return logoutElem;
    }
    public String rememberPasswordText(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String rememberMess = wait.until(ExpectedConditions.presenceOfElementLocated(validMessageForRememberPass)).getText();
        return rememberMess;
    }
}
