package page_object.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.TestBase;

import static page_object.WebDriverContainer.getDriver;
import static page_object.WebDriverContainer.quitDriver;

public class CartTest extends TestBase {

    @Test(description = "Открытие корзины")
    public static void openCart() {
        String emptyCartText = "There are no items in your cart.";
        CartPage cartPage = new CartPage();
        cartPage.openCart();
        cartPage.emptyCartGetMess();
        Assert.assertEquals(cartPage.emptyCartGetMess(), emptyCartText);
    }

    @Test(description = "Возврат из корзины")
    public static void exitFromCart() {
        String mainPage = "https://litecart.stqa.ru/images/slides/1-lonely-duck.jpg";
        CartPage cartPage = new CartPage();
        cartPage.openCart();
        cartPage.clickBackButton();
        cartPage.findMainPagePicture();
        Assert.assertEquals(cartPage.findMainPagePicture(), mainPage);
    }

    @Test(description = "отображение добавленных элементов в корзине")
    public static void checkCart() throws InterruptedException {
        String duckName = "Red Duck";
        CartPage cartPage = new CartPage();
        cartPage.chooseDuck();
        cartPage.getDuckName();
        Thread.sleep(2000);
        cartPage.openCart();
        cartPage.getDuckNameFromCart();
        Assert.assertEquals(cartPage.getDuckNameFromCart(), duckName);
    }
}

