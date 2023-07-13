package логин;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test(description = "Логирование с валидными кредами")
    public static void logWithValidCred() {
        String mail = "asanastasia@gmail.com";
        String password = "111";
        String logout = "Logout";

        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@name='remember_me']")).click();
        driver.findElement(By.xpath("//*[@name='login']")).click();

        WebElement logoutString = driver.findElement(By.xpath("//ul[@class='list-vertical']//a[@href='https://litecart.stqa.ru/en/logout']"));

        Assert.assertEquals(logoutString.getText(), logout);

        driver.quit();
    }

    @Test(description = "Логирование с невалидными кредами")
    public static void logWithInvalidCred() {
        String mail = "asanastasia@gmail.com";
        String password = "Asana11@";
        String loginPageError = "Login";

        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@name='remember_me']")).click();
        driver.findElement(By.xpath("//*[@name='login']")).click();

        WebElement loginPageErr = driver.findElement(By.cssSelector("h1[class]"));

        Assert.assertEquals(loginPageErr.getText(), loginPageError);

        driver.quit();
    }

    @Test(description = "Логирование без чек-бокса 'Remember Me'")
    public static void logWithoutCheckbox() {
        String mail = "asanastasia@gmail.com";
        String password = "111";
        String logout = "Logout";

        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@name='login']")).click();

        WebElement logoutString = driver.findElement(By.xpath("//ul[@class='list-vertical']//a[@href='https://litecart.stqa.ru/en/logout']"));

        Assert.assertEquals(logoutString.getText(), logout);

        driver.quit();
    }
    @Test(description = "Тестирование формы если забыл пароль")
        public static void notice(){
        String mail = "asanastasia1@gmail.com";
        String messageRememberMePassword = "A new password has been sent to your email address.";

        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/login");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@name='lost_password']")).click();
        WebElement message = driver.findElement(By.cssSelector("div[class='notice success']"));

        Assert.assertEquals(message.getText(), messageRememberMePassword);

        driver.quit();
    }
}
