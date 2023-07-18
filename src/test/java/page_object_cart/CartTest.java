package page_object_cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest {
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

    @Test(description = "Открытие корзины")
    public static void openCart() {
        String emptyCartText = "There are no items in your cart.";
        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();
        cartPage.emptyCartGetMess();
        Assert.assertEquals(cartPage.emptyCartGetMess(), emptyCartText);
    }

    @Test(description = "Возврат из корзины")
    public static void exitFromCart() {
        String mainPage = "https://litecart.stqa.ru/images/slides/1-lonely-duck.jpg";
        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();
        cartPage.clickBackButton();
        cartPage.findMainPagePicture();
        Assert.assertEquals(cartPage.findMainPagePicture(), mainPage);
    }

    @Test(description = "отображение добавленных элементов в корзине")
    public static void checkCart() throws InterruptedException {
        String duckName = "Red Duck";
        CartPage cartPage = new CartPage(driver);
        cartPage.chooseDuck();
        cartPage.getDuckName();
        Thread.sleep(2000);
        cartPage.openCart();
        cartPage.getDuckNameFromCart();
        Assert.assertEquals(cartPage.getDuckNameFromCart(), duckName);
    }
}

