package page_object_catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CatalogTest {

    private static String url = "https://litecart.stqa.ru/en/";

    private static WebDriver driver;

    @BeforeMethod
    public static void setup(){
        driver = new ChromeDriver();
        driver.get(url);
    }

    @AfterMethod
    public static void teardown(){
        driver.quit();
    }

    @Test(description = "Покупка утки")
    public static void selectDuck() throws InterruptedException {
        String resultAfterSale = "Your order is successfully completed!";
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.goToRuberDucksPage();
        catalogPage.selectDuck();
        catalogPage.selectSizeDuckAndAddCart();
        catalogPage.goToCart();
        catalogPage.byDuck();
        catalogPage.orderMessage();
        Assert.assertEquals(catalogPage.orderMessage(), resultAfterSale);
    }
}
