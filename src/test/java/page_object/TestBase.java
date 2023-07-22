package page_object;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static page_object.WebDriverContainer.getDriver;
import static page_object.WebDriverContainer.quitDriver;

public class TestBase {

    private static String url = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    public static void setup(){
        getDriver().get(url);
    }

    @AfterMethod
    public static void teardown(){
        quitDriver();
    }
}
