package page_object.selenide;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.TestBase;

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
