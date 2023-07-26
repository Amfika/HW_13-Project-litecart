package htmlelements.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.main.Locators;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static page_object.WebDriverContainer.getDriver;

@Name("Login block")
@FindBy(id = "box-account-login")
public class LoginBlock extends HtmlElement {

    @Name("Email input")
    @FindBy(name = "email")
    private WebElement emailInput;

    @Name("Password input")
    @FindBy(name = "password")
    private WebElement passwordInput;

    @Name("Login button")
    @FindBy(name = "login")
    private WebElement loginButton;

    @Name("Remember me checkbox")
    @FindBy(name = "remember_me")
    private WebElement rememberMe;

    @Name("Error message")
    @FindBy(css = "div[class='notice errors']")
    private WebElement errorMessage;

    @Name("Valid message")
    @FindBy(css = "div[class='notice success']")
    private WebElement validMessage;

    @Name("Valid message remember")
    @FindBy(css = "div[class='notice success']")
    private WebElement validMessageForRememberPass;

    @Name("Logout element")
    @FindBy(xpath = "//div[@class='content']/ul[@class='list-vertical']/li/a[@href='https://litecart.stqa.ru/en/logout']")
    private WebElement logout;

    @Name("Lost password button")
    @FindBy(name = "lost_password")
    private By lostPasswordButton;

    public void attemptLogin(String email, String password){
        getDriver().findElement((By) emailInput).sendKeys(email);
        getDriver().findElement((By) passwordInput).sendKeys(password);
        getDriver().findElement((By) rememberMe).click();
        getDriver().findElement((By) loginButton).click();
    }
    public String getErrorMessage(){
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        String invalMess = wait.until(ExpectedConditions.presenceOfElementLocated((By) errorMessage)).getText();
        return invalMess;
    }
}
