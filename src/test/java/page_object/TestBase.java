package page_object;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;
import static page_object.WebDriverContainer.getDriver;
import static page_object.WebDriverContainer.quitDriver;

public class TestBase {
    private static WebDriver driver;

    private static String url = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    public static void setup(){
        //getDriver().get(url);
        Configuration.baseUrl = url;
        Configuration.pageLoadTimeout = 5000;
        Configuration.browser = "chrome";
        open(url);
        WebDriver driver = WebDriverRunner.getWebDriver();

    }

    //@AfterMethod
    //public static void teardown(){
        //quitDriver();

    //}
}
