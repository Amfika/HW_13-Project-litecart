package page_object_catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderMenu {

    private static String url = "https://litecart.stqa.ru/en/";

    @Test(description = "Переход в каталог")
    public static void goToCatalog(){
        String searchText = "Rubber Ducks";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.goToRuberDucksPage();
        catalogPage.findHeader();
        Assert.assertEquals(catalogPage.findHeader(), searchText);
        driver.quit();
    }
}
