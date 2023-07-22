package page_object.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.TestBase;

import static page_object.WebDriverContainer.getDriver;
import static page_object.WebDriverContainer.quitDriver;

public class CatalogTest extends TestBase {

    @Test(description = "Покупка утки")
    public static void selectDuck() throws InterruptedException {
        String resultAfterSale = "Your order is successfully completed!";
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.goToRuberDucksPage();
        catalogPage.selectDuck();
        catalogPage.selectSizeDuckAndAddCart();
        catalogPage.goToCart();
        catalogPage.byDuck();
        catalogPage.orderMessage();
        Assert.assertEquals(catalogPage.orderMessage(), resultAfterSale);
    }
}
