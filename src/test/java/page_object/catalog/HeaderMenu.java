package page_object.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static page_object.WebDriverContainer.getDriver;
import static page_object.WebDriverContainer.quitDriver;

public class HeaderMenu {

    private static String url = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    public static void setup(){
        getDriver().get(url);
    }

    @AfterMethod
    public static void teardown(){
        quitDriver();
    }

    @Test(description = "Переход в каталог")
    public static void goToCatalog(){
        String searchText = "Rubber Ducks";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.goToRuberDucksPage();
        catalogPage.findHeader();
        Assert.assertEquals(catalogPage.findHeader(), searchText);
        driver.quit();
    }
}
